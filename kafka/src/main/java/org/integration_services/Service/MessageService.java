package org.integration_services.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.integration_services.entity.Entity1;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MessageService {

    @Autowired
    private StreamBridge streamBridge;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(MessageService.class);

    public void sendEntityA(Entity1 entity1) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String data = mapper.writeValueAsString(entity1);
            streamBridge.send("outputBinding-out-0", data);
        } catch (JsonProcessingException e) {
            logger.warning("Error serializing Entity1"+e);
        }
    }
}