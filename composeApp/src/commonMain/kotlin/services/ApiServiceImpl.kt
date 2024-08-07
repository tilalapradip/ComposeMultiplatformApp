package org.pradip.cmp.services

import io.ktor.client.call.body
import io.ktor.client.request.get
import org.pradip.cmp.KtorClient
import org.pradip.cmp.data.MobileItem

private const val GET_OBJECTS = "objects"

internal class ApiServiceImpl : ApiService {

    override suspend fun getMobiles(): List<MobileItem> {
        return KtorClient.client.get(GET_OBJECTS).body<List<MobileItem>>()
    }

    override suspend fun getMobilesFake(): List<MobileItem> {
        return KtorClient.jsonInstance.decodeFromString<List<MobileItem>>(JSON_DATA_STRING)
    }

    val JSON_DATA_STRING =
        "[\n" +
                "  {\n" +
                "    \"id\": \"1\",\n" +
                "    \"name\": \"Google Pixel 6 Pro\",\n" +
                "    \"data\": {\n" +
                "      \"color\": \"Cloudy White\",\n" +
                "      \"capacity\": \"128 GB\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"2\",\n" +
                "    \"name\": \"Apple iPhone 12 Mini, 256GB, Blue\",\n" +
                "    \"data\": null\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"3\",\n" +
                "    \"name\": \"Apple iPhone 12 Pro Max\",\n" +
                "    \"data\": {\n" +
                "      \"color\": \"Cloudy White\",\n" +
                "      \"capacity GB\": 512\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"4\",\n" +
                "    \"name\": \"Apple iPhone 11, 64GB\",\n" +
                "    \"data\": {\n" +
                "      \"price\": 389.99,\n" +
                "      \"color\": \"Purple\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5\",\n" +
                "    \"name\": \"Samsung Galaxy Z Fold2\",\n" +
                "    \"data\": {\n" +
                "      \"price\": 689.99,\n" +
                "      \"color\": \"Brown\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"6\",\n" +
                "    \"name\": \"Apple AirPods\",\n" +
                "    \"data\": {\n" +
                "      \"generation\": \"3rd\",\n" +
                "      \"price\": 120\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"7\",\n" +
                "    \"name\": \"Apple MacBook Pro 16\",\n" +
                "    \"data\": {\n" +
                "      \"year\": 2019,\n" +
                "      \"price\": 1849.99,\n" +
                "      \"CPU model\": \"Intel Core i9\",\n" +
                "      \"Hard disk size\": \"1 TB\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"8\",\n" +
                "    \"name\": \"Apple Watch Series 8\",\n" +
                "    \"data\": {\n" +
                "      \"Strap Colour\": \"Elderberry\",\n" +
                "      \"Case Size\": \"41mm\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"9\",\n" +
                "    \"name\": \"Beats Studio3 Wireless\",\n" +
                "    \"data\": {\n" +
                "      \"Color\": \"Red\",\n" +
                "      \"Description\": \"High-performance wireless noise cancelling headphones\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10\",\n" +
                "    \"name\": \"Apple iPad Mini 5th Gen\",\n" +
                "    \"data\": {\n" +
                "      \"Capacity\": \"64 GB\",\n" +
                "      \"Screen size\": 7.9\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"11\",\n" +
                "    \"name\": \"Apple iPad Mini 5th Gen\",\n" +
                "    \"data\": {\n" +
                "      \"Capacity\": \"254 GB\",\n" +
                "      \"Screen size\": 7.9\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"12\",\n" +
                "    \"name\": \"Apple iPad Air\",\n" +
                "    \"data\": {\n" +
                "      \"Generation\": \"4th\",\n" +
                "      \"Price\": \"419.99\",\n" +
                "      \"Capacity\": \"64 GB\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"13\",\n" +
                "    \"name\": \"Apple iPad Air\",\n" +
                "    \"data\": {\n" +
                "      \"Generation\": \"4th\",\n" +
                "      \"Price\": \"519.99\",\n" +
                "      \"Capacity\": \"256 GB\"\n" +
                "    }\n" +
                "  }\n" +
                "]"
}