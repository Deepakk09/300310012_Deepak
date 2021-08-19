package com.example._300310012Deepak;

import jdk.jpackage.internal.ApplicationLayout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
class MainControllerTest {

    @Mock
    LoanService loanService;


    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {



    }

    @Test
    void showloanPage() {
    }

    @Test
    void addTodo() {
    }

    @Test
    void showUpdateTodoPage() {
    }

    @Test
    void showUpdate() {
    }

    @Test
    void deleteTodo() {
    }
}