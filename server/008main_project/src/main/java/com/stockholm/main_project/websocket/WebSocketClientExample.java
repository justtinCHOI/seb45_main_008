// package com.stockholm.main_project.websocket;

// import org.java_websocket.client.WebSocketClient;
// import org.java_websocket.handshake.ServerHandshake;
// import java.net.URI;

// public class WebSocketClientExample extends WebSocketClient {

//     public WebSocketClientExample(URI serverUri) {
//         super(serverUri);
//     }

//     @Override
//     public void onOpen(ServerHandshake handshakedata) {
//         System.out.println("Connected to server");
//     }
    
//     @Override
//     public void onMessage(String message) {
//         System.out.println("Received: " + message);
//         // 받은 메시지 처리
//     }

//     @Override
//     public void onClose(int code, String reason, boolean remote) {
//         System.out.println("Disconnected from server");
//     }

//     @Override
//     public void onError(Exception ex) {
//         ex.printStackTrace();
//     }

//     public static void main(String[] args) {
//         try {
//             String appKey = "앱키를 입력하세요";
//             String appSecret = "앱 시크릿키를 입력하세요";

//             String approvalKey = WebSocketUtil.getApprovalKey(appKey, appSecret);
//             System.out.println("Approval Key: " + approvalKey);

//             String url = "ws://ops.koreainvestment.com:21000";
//             WebSocketClientExample client = new WebSocketClientExample(new URI(url));
//             client.connectBlocking();

//             // 예시: 국내주식 호가 요청
//             String request = "{\"type\":\"subscribe\", \"symbols\":[\"005930\"]}";
//             client.send(request);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }
