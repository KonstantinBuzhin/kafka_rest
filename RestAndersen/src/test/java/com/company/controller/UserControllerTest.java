package com.company.controller;

import com.company.model.User;
import com.company.service.UserService;
import com.company.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;
//    @InjectMocks
//    private UserController userController;

    private MockMvc mockMvc;

//    @BeforeEach
//    public void setUp() {
//        mockMvc = MockMvcBuilders
//                .standaloneSetup(userController)
//                .build();
//    }
//
//    @Test
//    public void shouldReturnUsers() throws Exception {
//        Collection<User> expected = getExpectedUsers();
//
//        when(userService.getAll()).thenReturn(expected);
//
//        String contentAsString = mockMvc.perform(get("/api/users")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        Collection<User> actual = JsonUtil.fromJson(contentAsString, new TypeReference<Collection<User>>() {
//        });
//
//        assertEquals(new ArrayList<>(expected), actual);
//    }
//
//    @Test
//    public void shouldReturnUser() throws Exception {
//        User expected = getExpectedUser();
//
//        when(userService.getById(1)).thenReturn(expected);
//
//        String contentAsString = mockMvc.perform(get("/api/users/{id}", 1)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        User actual = JsonUtil.fromJson(contentAsString, User.class);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldCreateUser() throws Exception {
//        User user = getExpectedUser();
//        user.setId(null);
//
//        doAnswer((Answer<Void>) invocationOnMock -> {
//            User argument = invocationOnMock.getArgument(0, User.class);
//            argument.setId(1);
//            return null;
//        }).when(userService).create(user);
//
//        mockMvc.perform(post("/api/users")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(JsonUtil.toJson(user)))
//                .andExpect(status().is(201));
//
//        verify(userService).create(getExpectedUser());
//    }
//
//    @Test
//    public void shouldUpdateUser() throws Exception {
//        User expected = getExpectedUser();
//        expected.setId(null);
//
//        when(userService.update(getExpectedUser())).thenReturn(getExpectedUser());
//
//        String contentAsString = mockMvc.perform(put("/api/users/{id}", 1)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(JsonUtil.toJson(expected)))
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        User actual = JsonUtil.fromJson(contentAsString, User.class);
//
//        assertEquals(getExpectedUser(), actual);
//    }
//
//    @Test
//    public void shouldDeleteUser() throws Exception {
//        mockMvc.perform(delete("/api/users/{id}", 1))
//                .andExpect(status().is(204));
//
//        verify(userService).deleteById(1);
//    }
//
//    private Collection<User> getExpectedUsers() {
//        Collection<User> users = new ArrayList<>();
//        users.add(new User(1, "name1"));
//        users.add(new User(2, "name2"));
//
//        return users;
//    }
//
//    private User getExpectedUser() {
//        return new User(1, "name1");
//    }
}
