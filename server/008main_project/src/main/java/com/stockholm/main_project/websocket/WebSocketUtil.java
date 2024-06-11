// package com.stockholm.main_project.websocket;
// import org.json.JSONObject;
// import java.net.HttpURLConnection;
// import java.net.URL;
// import java.io.OutputStream;
// import java.io.BufferedReader;
// import java.io.InputStreamReader;

// public class WebSocketUtil {
//     public static String getApprovalKey(String key, String secret) throws Exception {
//         String url = "https://openapi.koreainvestment.com:9443/oauth2/Approval";
//         URL obj = new URL(url);
//         HttpURLConnection con = (HttpURLConnection) obj.openConnection();

//         con.setRequestMethod("POST");
//         con.setRequestProperty("Content-Type", "application/json");

//         JSONObject body = new JSONObject();
//         body.put("grant_type", "client_credentials");
//         body.put("appkey", key);
//         body.put("secretkey", secret);

//         con.setDoOutput(true);
//         OutputStream os = con.getOutputStream();
//         os.write(body.toString().getBytes());
//         os.flush();
//         os.close();

//         int responseCode = con.getResponseCode();
//         BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//         String inputLine;
//         StringBuffer response = new StringBuffer();

//         while ((inputLine = in.readLine()) != null) {
//             response.append(inputLine);
//         }
//         in.close();

//         JSONObject jsonResponse = new JSONObject(response.toString());
//         return jsonResponse.getString("approval_key");
//     }
// }