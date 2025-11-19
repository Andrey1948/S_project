package integration.http.controller;

import lombok.RequiredArgsConstructor;
import org.ferggx.SpringProject.ApplicationRunner;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.ferggx.SpringProject.dto.UserCreateEditDto;
import org.ferggx.SpringProject.dto.UserCreateEditDto.Fields.*;
import org.springframework.transaction.annotation.Transactional;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;




//@ActiveProfiles("test")
@SpringBootTest(classes = {ApplicationRunner.class})
@Transactional
@AutoConfigureMockMvc
@RequiredArgsConstructor
public class UserControllerIT {
    private final MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("user/users"))
                .andExpect(model().attributeExists("users"))
                .andExpect(model().attribute("users", IsCollectionWithSize.hasSize(5)));
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/users")
                        .param(UserCreateEditDto.Fields.username, "test@gmail.com")
                        .param(UserCreateEditDto.Fields.firstname, "Test")
                        .param(UserCreateEditDto.Fields.lastname, "TestTest")
                        .param(UserCreateEditDto.Fields.role, "ADMIN")
                        .param(UserCreateEditDto.Fields.companyId, "1")
                        .param(UserCreateEditDto.Fields.birthDate, "01-01-2000")
                )
                .andExpectAll(
                        status().is3xxRedirection(),
                        redirectedUrlPattern("/users/{\\d+}")
                );
    }

}
