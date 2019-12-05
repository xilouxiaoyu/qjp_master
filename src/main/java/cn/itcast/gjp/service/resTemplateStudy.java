package cn.itcast.gjp.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
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
    public  void queryMember() throws RestClientException, JSONException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
       /* HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity(headers);
        ResponseEntity<JSONObject> exchange = restTemplate.exchange("http:", HttpMethod.GET, (HttpEntity<?>) requestEntity,JSONObject.class);*/
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mobile","13012341246");
        jsonObject.put("nameId","A25145492-E25745442");
        jsonObject.put("token",";4zvkHRLT2W?q2@k;WsnYkQjU}i?y7GZlp>YI2pOK@B>ieKQ=VtHHVggVCiSweB1V");
        jsonObject.put("userId","100004132");
        HttpEntity httpEntity = new HttpEntity(jsonObject.toString(), headers);
        restTemplate.exchange("http", HttpMethod.GET, (HttpEntity<?>) httpEntity,JSONObject.class);


    }
}
