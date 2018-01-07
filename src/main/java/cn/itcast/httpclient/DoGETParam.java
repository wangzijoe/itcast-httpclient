package cn.itcast.httpclient;

import java.net.URI;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DoGETParam {

    public static void main(String[] args) throws Exception {

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 定义请求的参数
        URI uri = new URIBuilder("http://192.168.1.157/api/employee/EmployeeList")
//                .setParameter("id", "174")
                .setParameter("currentPage", "1")
                .setParameter("pageSize", "10")
                .setParameter("totalRows", "1")
                .setParameter("openId", "oipP20O4mcESAPsQL6tujyey6Mac")
                .build();
//                .setParameter("status", "20")
//                .setParameter("type", "10")
//                .setParameter("type1", "10")
//                .setParameter("status", "24")
//                .setParameter("status1", "224")
//                .setParameter("appId", "24")
//                .setParameter("subjectId", "2")
//                .setParameter("status", "20")
//                .setParameter("courierId", "ABC")
//                .setParameter("code", "13179501122")

        System.out.println(uri);

        // 创建http GET请求
        HttpGet httpGet = new HttpGet(uri);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }

    }

}
