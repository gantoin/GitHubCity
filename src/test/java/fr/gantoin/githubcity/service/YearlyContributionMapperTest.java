package fr.gantoin.githubcity.service;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.gantoin.githubcity.domain.YearlyContribution;
import kong.unirest.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
public class YearlyContributionMapperTest {

    private final YearlyContributionMapper yearlyContributionMapper = new YearlyContributionMapper();

    @Test
    public void map() {
        try {
            YearlyContribution yearlyContribution = yearlyContributionMapper.map(loadFIle());
            assertThat(yearlyContribution).isNotNull();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JSONObject loadFIle() throws IOException {
        InputStream is = new ClassPathResource("response_test.json").getInputStream();
        String jsonTxt = IOUtils.toString(is, UTF_8);
        return new JSONObject(jsonTxt);
    }
}
