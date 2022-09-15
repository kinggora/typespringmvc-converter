package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data"); //문자 타입으로 조회
        Integer intValue = Integer.valueOf(data); //Integer 타입으로 변환
        log.info("intValue = {}", intValue);
        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam("data") Integer data) {
        log.info("RequestParam.data = {}", data);
        return "ok";
    }

    @GetMapping("/ip-port")
    public String helloV3(@RequestParam IpPort ipPort){
        log.info("ipPort.ip = {}", ipPort.getIp());
        log.info("ipPort.port = {}", ipPort.getPort());
        return "ok";

    }
}
