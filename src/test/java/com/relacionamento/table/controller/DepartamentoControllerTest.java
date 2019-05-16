package com.relacionamento.table.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relacionamento.table.Application;
import com.relacionamento.table.exception.BusinessException;
import com.relacionamento.table.model.Departamento;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class DepartamentoControllerTest extends IntegrationTestMock {


    private final String PATH = "/v1";
    private final String PATH_CREATE = PATH + "/request-departamento";

    @Test
    @SneakyThrows
    public void findAll() {
        getDepartamento();
        this.mockMvc
                .perform(get(PATH)
                        .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());
        List<Departamento> list = departamentoRepository.findAll();
        Assertions.assertThat(list).isNotNull();
    }

    @Test
    @SneakyThrows
    public void Create() {

        byte[] payload = buildCompany("RH");

        this.mockMvc
                .perform(post(PATH_CREATE)
                        .content(payload)
                        .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id", Matchers.notNullValue()));

        ObjectMapper mapper = new ObjectMapper();
        Departamento id = mapper.readValue(payload, Departamento.class);

        Assertions.assertThat(id.getNome()).isEqualTo("RH");
    }

    @Test
    @SneakyThrows
    public void naoInserirNomeVazioParaODepartamento() {

        byte[] payload = buildCompany("");

        this.mockMvc
                .perform(post(PATH_CREATE)
                        .content(payload)
                        .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isPreconditionFailed());
    }
}
