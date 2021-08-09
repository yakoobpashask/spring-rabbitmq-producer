package com.evoke;

import static org.mockito.ArgumentMatchers.eq;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.evoke.model.Employee;
import com.evoke.service.RabbitMQSender;

@RunWith(MockitoJUnitRunner.class)
public class SpringRabbitMQProducerTest {

    @Mock
    private RabbitTemplate rabbitTemplateMock;
    @InjectMocks
    private RabbitMQSender messageSender;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    /*
     * @Before public void setUp() { this.rabbitTemplateMock = Mockito.mock(RabbitTemplate.class);
     * this.messageSender = new MessageSender(this.rabbitTemplateMock); }
     */

    @Test
    public void sendEmployeeMessage() {
        Employee employee = new Employee("100", "emp100");

        // assertThatCode(() -> this.messageSender.send(employee)).doesNotThrowAnyException();
        Mockito.verify(this.rabbitTemplateMock)
                .convertAndSend(eq("2154-exchange"), eq("2154-routingkey"), eq(employee));

        /*
         * Employee e = new Employee(800, "Kohli", "7766554433", "kohli@gmail.com", "pasha", new
         * Date()); empService.addEmployee(e); verify(empRepo, times(1)).save(e);
         */

    }

}
