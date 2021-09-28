package com.example.jetpackcompose.interactors.launches

import com.example.jetpackcompose.data.dto.Launch
import com.example.jetpackcompose.data.remote.MockWebServerResponses
import com.example.jetpackcompose.data.remote.SpacexAPI
import com.google.gson.GsonBuilder
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class GetLaunchesUseCaseTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var baseUrl: HttpUrl
    private lateinit var getLaunchesUseCase: GetLaunchesUseCase
    private lateinit var api: SpacexAPI

    @BeforeEach
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        baseUrl = mockWebServer.url("/v4/launches/")
        api = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(SpacexAPI::class.java)

        getLaunchesUseCase = GetLaunchesUseCase(api = api)
    }

    @Test
    fun getAllLaunchesFromNetwork(): Unit = runBlocking {

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(MockWebServerResponses.launchListResponse)
        )

        // run use case
        val launchesAsFlow = getLaunchesUseCase.execute().toList()

        // first emission should be `loading`
        assert(launchesAsFlow[0].loading)

        // second emission should be the launches
        val launches: List<Launch> = launchesAsFlow[1].data as List<Launch>

        // check size, values etc
        assert(launches.size == 3)
        assertThat(launches[0], instanceOf(Launch::class.java))
        assertTrue(launches[0].name == "FalconSat")

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
        val launchesAsFlow = getLaunchesUseCase.execute().toList()

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
