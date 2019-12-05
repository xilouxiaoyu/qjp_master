package cn.itcast.gjp.service;

import cn.itcast.gjp.domain.user;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

/**
 * @author apple
 * @date 2019/12/5 下午4:53
 */
public class resTemplateStudy{

    @Test
    public  void queryBaidu() throws RestClientException, JSONException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity(headers);
        ResponseEntity<String> exchange = restTemplate.exchange("http://ckmobile-nginx-10-10-76-162.okd.iqianjin.test/userMemberLevel/sendRelegationAward", HttpMethod.GET, (HttpEntity<?>) requestEntity,String.class);
    }
}
