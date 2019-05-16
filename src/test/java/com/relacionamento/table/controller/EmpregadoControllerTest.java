package com.relacionamento.table.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relacionamento.table.model.Departamento;
import com.relacionamento.table.model.Empregado;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmpregadoControllerTest extends IntegrationTestMock {

    private final String PATH = "/v2";
    private final String PATH_CREATE = PATH + "/request-empregado";

    @Test
    @SneakyThrows
    public void findAll() {
        getDepartamento();
        getEmpregado();
        this.mockMvc
                .perform(get(PATH)
                        .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());

        List<Departamento> departamentoList = departamentoRepository.findAll();
        Assertions.assertThat(departamentoList).isNotNull();

        List<Empregado> empregadoList = empregadoRepository.findAll();
        Assertions.assertThat(empregadoList).isNotNull();
    }

    @Test
    @SneakyThrows
    public void Create() {
        Departamento request = getDepartamento();

        byte[] payloadRequest = buildCompany(request.getNome());

        String payload = IOUtils.toString(getClass()
                .getClassLoader()
                .getResourceAsStream("payload/empregado.json"));

        this.mockMvc
                .perform(post(PATH_CREATE)
                        .content(payload)
                        .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.id", Matchers.notNullValue()));



        ObjectMapper mapper = new ObjectMapper();
        Departamento departamento = mapper.readValue(payloadRequest, Departamento.class);
        Empregado empregado = mapper.readValue(payload, Empregado.class);

        Assertions.assertThat(departamento.getNome()).isEqualTo("RH");
        Assertions.assertThat(empregado.getNome()).isEqualTo("Daniel");
    }
    @Test
    @SneakyThrows
    public void naoIserirCamposVaziosParaOEmpregado() {
        Departamento request = getDepartamento();
        String payload = IOUtils.toString(getClass()
                .getClassLoader()
                .getResourceAsStream("payload/empregadoNull.json"));

        this.mockMvc
                .perform(post(PATH_CREATE)
                        .content(payload)
                        .contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isPreconditionFailed());
    }

}
