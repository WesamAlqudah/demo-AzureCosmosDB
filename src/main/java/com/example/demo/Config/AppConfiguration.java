//package com.example.demo.Config;
//
//import com.azure.core.credential.AzureKeyCredential;
//import com.azure.cosmos.CosmosClientBuilder;
//import com.azure.cosmos.DirectConnectionConfig;
//import com.azure.cosmos.GatewayConnectionConfig;
//import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
//import com.azure.spring.data.cosmos.config.CosmosConfig;
//import com.azure.spring.data.cosmos.core.ResponseDiagnostics;
//import com.azure.spring.data.cosmos.core.ResponseDiagnosticsProcessor;
//import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
//import io.micrometer.core.lang.Nullable;
//import lombok.Value;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableCosmosRepositories
//public class AppConfiguration extends AbstractCosmosConfiguration {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfiguration.class);
//
//    @Value("${azure.cosmos.uri}")
//    private String uri;
//
//    @Value("${azure.cosmos.key}")
//    private String key;
//
//    @Value("${azure.cosmos.secondaryKey}")
//    private String secondaryKey;
//
//    @Value("${azure.cosmos.database}")
//    private String dbName;
//
//    @Value("${azure.cosmos.queryMetricsEnabled}")
//    private boolean queryMetricsEnabled;
//
//    @Value("${azure.cosmos.maxDegreeOfParallelism}")
//    private int maxDegreeOfParallelism;
//
//    @Value("${azure.cosmos.maxBufferedItemCount}")
//    private int maxBufferedItemCount;
//
//    @Value("${azure.cosmos.responseContinuationTokenLimitInKb}")
//    private int responseContinuationTokenLimitInKb;
//
//    private AzureKeyCredential azureKeyCredential;
//
//    @Bean
//    public CosmosClientBuilder getCosmosClientBuilder() {
//        this.azureKeyCredential = new AzureKeyCredential(key);
//        DirectConnectionConfig directConnectionConfig = new DirectConnectionConfig();
//        GatewayConnectionConfig gatewayConnectionConfig = new GatewayConnectionConfig();
//        return new CosmosClientBuilder()
//                .endpoint(uri)
//                .credential(azureKeyCredential)
//                .directMode(directConnectionConfig, gatewayConnectionConfig);
//    }
//
//    @Override
//    public CosmosConfig cosmosConfig() {
//        return CosmosConfig.builder()
//                .enableQueryMetrics(queryMetricsEnabled)
//                .maxDegreeOfParallelism(maxDegreeOfParallelism)
//                .maxBufferedItemCount(maxBufferedItemCount)
//                .responseContinuationTokenLimitInKb(responseContinuationTokenLimitInKb)
//                .responseDiagnosticsProcessor(new ResponseDiagnosticsProcessorImplementation())
//                .build();
//    }
//
//    public void switchToSecondaryKey() {
//        this.azureKeyCredential.update(secondaryKey);
//    }
//
//    @Override
//    protected String getDatabaseName() {
//        return "testdb";
//    }
//
//    private static class ResponseDiagnosticsProcessorImplementation implements ResponseDiagnosticsProcessor {
//
//        @Override
//        public void processResponseDiagnostics(@Nullable ResponseDiagnostics responseDiagnostics) {
//            LOGGER.info("Response Diagnostics {}", responseDiagnostics);
//        }
//    }
//
//}
