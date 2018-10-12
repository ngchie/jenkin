package com.wng.jenkin;

import com.wng.jenkin.controller.MessageController;
import com.wng.jenkin.datamodel.Topic;

import com.wng.jenkin.ex.ResourceNotFoundException;
import com.wng.jenkin.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MessageController.class)
public class MessageControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService messageService;

    @Test
    public void getTopic() throws Exception {
        given(messageService.getTopic(anyLong())).willReturn(new Topic(Long.valueOf(1), "IPHONE8"));
        this.mockMvc.perform(get("/api/messageapp/topic/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value("1"))
                .andExpect(jsonPath("topic").value("IPHONE8"));
    }

    @Test()
    public void getTopic_Exception() throws Exception {

            given(messageService.getTopic(anyLong())).willThrow(new ResourceNotFoundException("not found"));
            this.mockMvc.perform(get("/api/messageapp/topic/1"))
                    .andExpect(status().isNotFound());

    }


}
