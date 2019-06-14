package com.morgana.user.amqp.provider;

import com.morgana.mq.annotation.TransMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserSender {

    @TransMessage(exchange = "user.exchange", bindingKey = "user.key", bizName = "create",
            dbCoordinator = "DBRedisCoordinator")
    public String transSend(){
        log.info("Create User Sender");
        return "000";
    }

}
