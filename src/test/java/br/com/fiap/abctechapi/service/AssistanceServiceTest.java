package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.service.impl.AssistanceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import javax.annotation.security.RunAs;
import java.util.List;

@SpringBootTest
public class AssistanceServiceTest {



    private AssistanceService assistanceService;
    @MockBean
    private AssistanceRepository assistanceRepository;


    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        assistanceService = new AssistanceServiceImpl(assistanceRepository);
    }


    @Test
    public void test_list_assistance(){
        Mockito.when(assistanceRepository.findAll())
                .thenReturn(
                        List.of(new Assistance(1L, "Test", "Test Description")));
        List<Assistance> list = assistanceService.getAssists();
        Assertions.assertNotNull(list);
        Assertions.assertEquals(list.size(), 1);
    }

}
