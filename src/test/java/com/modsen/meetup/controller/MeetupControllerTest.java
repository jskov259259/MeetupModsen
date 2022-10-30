package com.modsen.meetup.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.modsen.meetup.model.Meetup;
import com.modsen.meetup.service.MeetupService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class MeetupControllerTest {

    @InjectMocks
    private MeetupController meetupController;

    @Mock
    private MeetupService meetupService;

    @Captor
    private ArgumentCaptor<Long> captorId;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(meetupController)
                .build();
    }

    @Test
    public void testFindAll() throws Exception {
        Mockito.when(meetupService.findAll(new HashMap<String, String>()))
                .thenReturn(getMeetupList());

        mockMvc.perform(
                MockMvcRequestBuilders.get("/meetups").accept(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].theme", Matchers.is("Birthday")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].location", Matchers.is("Vitebsk")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].theme", Matchers.is("Easter")));

        Mockito.verify(meetupService).findAll(new HashMap<String, String>());
    }

    @Test
    public void testFindMeetupById() throws Exception {
        Meetup meetup = getMeetupList().get(0);

        Mockito.when(meetupService.findMeetupById(meetup.getId())).thenReturn(meetup);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/meetups/1")
        )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.theme", Matchers.is("Birthday")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.organizer", Matchers.is("Andrey")));

        Mockito.verify(meetupService).findMeetupById(captorId.capture());

        Long id = captorId.getValue();
        Assertions.assertEquals(1, id);
    }

    @Test
    public void testSaveMeetup() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/meetup")
                .content(asJsonString(getMeetupList().get(0)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateMeetup() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .put("/meetup")
                .content(asJsonString(getMeetupList().get(0)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteMeetup() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders.delete("/meetups/{id}", 1) )
                .andExpect(status().isOk());
    }


    private List<Meetup> getMeetupList() {

        List<Meetup> list = new ArrayList<>();
        Meetup meetup1 = new Meetup(1L, "Birthday", "Andrey birthday", "Andrey", LocalDateTime.now(), "Vitebsk");
        Meetup meetup2 = new Meetup(2L, "Easter", "Easter party", "Anton", LocalDateTime.of(2022, 9, 1, 20, 0, 0), "Minsk");
        list.add(meetup1);
        list.add(meetup2);
        return list;
    }


    private String asJsonString(Meetup meetup) throws JsonProcessingException {
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = Obj.writeValueAsString(meetup);
        System.out.println(jsonStr);
        return jsonStr;
    }


}