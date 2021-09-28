package com.example.jetpackcompose.data.remote

object MockWebServerResponses {

    /**
     * launches from api
     */
    val launchListResponse: String  = "[\n" +
            "  {\n" +
            "    \"success\": false,\n" +
            "    \"name\": \"FalconSat\",\n" +
            "    \"date_utc\": \"2006-03-24T22:30:00.000Z\",\n" +
            "    \"date_unix\": 1143239400,\n" +
            "    \"date_local\": \"2006-03-25T10:30:00+12:00\",\n" +
            "    \"id\": \"5eb87cd9ffd86e000604b32a\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"success\": false,\n" +
            "    \"name\": \"DemoSat\",\n" +
            "    \"date_utc\": \"2007-03-21T01:10:00.000Z\",\n" +
            "    \"date_unix\": 1174439400,\n" +
            "    \"date_local\": \"2007-03-21T13:10:00+12:00\",\n" +
            "    \"id\": \"5eb87cdaffd86e000604b32b\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"success\": false,\n" +
            "    \"name\": \"RatSat\",\n" +
            "    \"date_utc\": \"2008-09-28T23:15:00.000Z\",\n" +
            "    \"date_unix\": 1222643700,\n" +
            "    \"date_local\": \"2008-09-28T11:15:00+12:00\",\n" +
            "    \"id\": \"5eb87cdbffd86e000604b32d\"\n" +
            "  }\n" +
            "]"

    val launchesQueryResponse: String = "{\n" +
            "    \"docs\": [\n" +
            "        {\n" +
            "            \"fairings\": {\n" +
            "                \"reused\": false,\n" +
            "                \"recovery_attempt\": false,\n" +
            "                \"recovered\": false,\n" +
            "                \"ships\": []\n" +
            "            },\n" +
            "            \"links\": {\n" +
            "                \"patch\": {\n" +
            "                    \"small\": \"https://images2.imgbox.com/3c/0e/T8iJcSN3_o.png\",\n" +
            "                    \"large\": \"https://images2.imgbox.com/40/e3/GypSkayF_o.png\"\n" +
            "                },\n" +
            "                \"reddit\": {\n" +
            "                    \"campaign\": null,\n" +
            "                    \"launch\": null,\n" +
            "                    \"media\": null,\n" +
            "                    \"recovery\": null\n" +
            "                },\n" +
            "                \"flickr\": {\n" +
            "                    \"small\": [],\n" +
            "                    \"original\": []\n" +
            "                },\n" +
            "                \"presskit\": null,\n" +
            "                \"webcast\": \"https://www.youtube.com/watch?v=0a_00nJ_Y88\",\n" +
            "                \"youtube_id\": \"0a_00nJ_Y88\",\n" +
            "                \"article\": \"https://www.space.com/2196-spacex-inaugural-falcon-1-rocket-lost-launch.html\",\n" +
            "                \"wikipedia\": \"https://en.wikipedia.org/wiki/DemoSat\"\n" +
            "            },\n" +
            "            \"static_fire_date_utc\": \"2006-03-17T00:00:00.000Z\",\n" +
            "            \"static_fire_date_unix\": 1142553600,\n" +
            "            \"net\": false,\n" +
            "            \"window\": 0,\n" +
            "            \"rocket\": \"5e9d0d95eda69955f709d1eb\",\n" +
            "            \"success\": false,\n" +
            "            \"failures\": [\n" +
            "                {\n" +
            "                    \"time\": 33,\n" +
            "                    \"altitude\": null,\n" +
            "                    \"reason\": \"merlin engine failure\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"details\": \"Engine failure at 33 seconds and loss of vehicle\",\n" +
            "            \"crew\": [],\n" +
            "            \"ships\": [],\n" +
            "            \"capsules\": [],\n" +
            "            \"payloads\": [\n" +
            "                \"5eb0e4b5b6c3bb0006eeb1e1\"\n" +
            "            ],\n" +
            "            \"launchpad\": \"5e9e4502f5090995de566f86\",\n" +
            "            \"flight_number\": 1,\n" +
            "            \"name\": \"FalconSat\",\n" +
            "            \"date_utc\": \"2006-03-24T22:30:00.000Z\",\n" +
            "            \"date_unix\": 1143239400,\n" +
            "            \"date_local\": \"2006-03-25T10:30:00+12:00\",\n" +
            "            \"date_precision\": \"hour\",\n" +
            "            \"upcoming\": false,\n" +
            "            \"cores\": [\n" +
            "                {\n" +
            "                    \"core\": \"5e9e289df35918033d3b2623\",\n" +
            "                    \"flight\": 1,\n" +
            "                    \"gridfins\": false,\n" +
            "                    \"legs\": false,\n" +
            "                    \"reused\": false,\n" +
            "                    \"landing_attempt\": false,\n" +
            "                    \"landing_success\": null,\n" +
            "                    \"landing_type\": null,\n" +
            "                    \"landpad\": null\n" +
            "                }\n" +
            "            ],\n" +
            "            \"auto_update\": true,\n" +
            "            \"tbd\": false,\n" +
            "            \"launch_library_id\": null,\n" +
            "            \"id\": \"5eb87cd9ffd86e000604b32a\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"fairings\": {\n" +
            "                \"reused\": false,\n" +
            "                \"recovery_attempt\": false,\n" +
            "                \"recovered\": false,\n" +
            "                \"ships\": []\n" +
            "            },\n" +
            "            \"links\": {\n" +
            "                \"patch\": {\n" +
            "                    \"small\": \"https://images2.imgbox.com/4f/e3/I0lkuJ2e_o.png\",\n" +
            "                    \"large\": \"https://images2.imgbox.com/be/e7/iNqsqVYM_o.png\"\n" +
            "                },\n" +
            "                \"reddit\": {\n" +
            "                    \"campaign\": null,\n" +
            "                    \"launch\": null,\n" +
            "                    \"media\": null,\n" +
            "                    \"recovery\": null\n" +
            "                },\n" +
            "                \"flickr\": {\n" +
            "                    \"small\": [],\n" +
            "                    \"original\": []\n" +
            "                },\n" +
            "                \"presskit\": null,\n" +
            "                \"webcast\": \"https://www.youtube.com/watch?v=Lk4zQ2wP-Nc\",\n" +
            "                \"youtube_id\": \"Lk4zQ2wP-Nc\",\n" +
            "                \"article\": \"https://www.space.com/3590-spacex-falcon-1-rocket-fails-reach-orbit.html\",\n" +
            "                \"wikipedia\": \"https://en.wikipedia.org/wiki/DemoSat\"\n" +
            "            },\n" +
            "            \"static_fire_date_utc\": null,\n" +
            "            \"static_fire_date_unix\": null,\n" +
            "            \"net\": false,\n" +
            "            \"window\": 0,\n" +
            "            \"rocket\": \"5e9d0d95eda69955f709d1eb\",\n" +
            "            \"success\": false,\n" +
            "            \"failures\": [\n" +
            "                {\n" +
            "                    \"time\": 301,\n" +
            "                    \"altitude\": 289,\n" +
            "                    \"reason\": \"harmonic oscillation leading to premature engine shutdown\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"details\": \"Successful first stage burn and transition to second stage, maximum altitude 289 km, Premature engine shutdown at T+7 min 30 s, Failed to reach orbit, Failed to recover first stage\",\n" +
            "            \"crew\": [],\n" +
            "            \"ships\": [],\n" +
            "            \"capsules\": [],\n" +
            "            \"payloads\": [\n" +
            "                \"5eb0e4b6b6c3bb0006eeb1e2\"\n" +
            "            ],\n" +
            "            \"launchpad\": \"5e9e4502f5090995de566f86\",\n" +
            "            \"flight_number\": 2,\n" +
            "            \"name\": \"DemoSat\",\n" +
            "            \"date_utc\": \"2007-03-21T01:10:00.000Z\",\n" +
            "            \"date_unix\": 1174439400,\n" +
            "            \"date_local\": \"2007-03-21T13:10:00+12:00\",\n" +
            "            \"date_precision\": \"hour\",\n" +
            "            \"upcoming\": false,\n" +
            "            \"cores\": [\n" +
            "                {\n" +
            "                    \"core\": \"5e9e289ef35918416a3b2624\",\n" +
            "                    \"flight\": 1,\n" +
            "                    \"gridfins\": false,\n" +
            "                    \"legs\": false,\n" +
            "                    \"reused\": false,\n" +
            "                    \"landing_attempt\": false,\n" +
            "                    \"landing_success\": null,\n" +
            "                    \"landing_type\": null,\n" +
            "                    \"landpad\": null\n" +
            "                }\n" +
            "            ],\n" +
            "            \"auto_update\": true,\n" +
            "            \"tbd\": false,\n" +
            "            \"launch_library_id\": null,\n" +
            "            \"id\": \"5eb87cdaffd86e000604b32b\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"totalDocs\": 145,\n" +
            "    \"limit\": 2,\n" +
            "    \"totalPages\": 73,\n" +
            "    \"page\": 1,\n" +
            "    \"pagingCounter\": 1,\n" +
            "    \"hasPrevPage\": false,\n" +
            "    \"hasNextPage\": true,\n" +
            "    \"prevPage\": null,\n" +
            "    \"nextPage\": 2\n" +
            "}"

}