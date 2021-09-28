package com.example.jetpackcompose.interactors.launches

import com.example.jetpackcompose.data.dto.Launch
import com.example.jetpackcompose.data.dto.LaunchesResponse
import com.example.jetpackcompose.data.remote.*
import com.google.gson.GsonBuilder
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class QueryLaunchesUseCaseTest {

    private lateinit var query: SpaceXQuery
    private lateinit var mockWebServer: MockWebServer
    private lateinit var baseUrl: HttpUrl
    private lateinit var sut: QueryLaunchesUseCase
    private lateinit var api: SpacexAPI

    @BeforeEach
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        baseUrl = mockWebServer.url("/v4/launches/query/")
        api = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(SpacexAPI::class.java)

        query = SpaceXQuery()
        sut = QueryLaunchesUseCase(api = api)
    }

    @Test
    fun getAllLaunchesFromNetwork(): Unit = runBlocking {

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(MockWebServerResponses.launchesQueryResponse)
        )

        // run use case
        val launchesAsFlow = sut.execute(query = query).toList()

        // first emission should be `loading`
        assert(launchesAsFlow[0].loading)

        // second emission should be the LaunchesResponse
        val launches: LaunchesResponse = launchesAsFlow[1].data as LaunchesResponse

        // check size, values etc
        assertEquals(launches.docs.size, 2)
        assertThat(launches.docs[0], instanceOf(Launch::class.java))
        assertTrue(launches.docs[0].name == "FalconSat")

        // 'loading' should be false now
        assert(!launchesAsFlow[1].loading)
    }

    @Test
    fun getAllLaunchesFromNetworkShowError(): Unit = runBlocking {
        // condition the response
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_INTERNAL_ERROR)
        )

        // run use case
        val launchesAsFlow = sut.execute(query = query).toList()

        // first emission should be `loading`
        assert(launchesAsFlow[0].loading)

        // error message displayed
        assertTrue(launchesAsFlow[1].error == "HTTP 500 Server Error")

        // 'loading' should be false now
        assert(!launchesAsFlow[1].loading)
    }

    @AfterEach
    fun tearDown() {
        mockWebServer.shutdown()
    }
}
