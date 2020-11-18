package com.bai.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: FlowLimitController
 * @Description: com.bai.controller
 * @Auther: baisonglin
 * @Version: 1.0
 * @create: 2020/11/17 11:30
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String testA(){
        return "******this is A";
    }
    @GetMapping(value = "/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"\t"+"***testB");
        return "******this is B";
    }
    @GetMapping(value = "/testD")
    public String testD(){
       /* try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("this is testD  RT");*/
        int a=10/0;
        log.info("this is testD  异常比例");
        return "!!!!!TESTD";
    }@GetMapping(value = "/testE")
    public String testE(){
        int a=10/0;
        log.info("this is testE  异常数");
        return "!!!!!TESTE";
    }

    @GetMapping(value = "/hotkey")
    @SentinelResource(value = "hotkey",blockHandler = "hotkeyhandler")
    public String hotkey(@RequestParam(value = "p1",required = false)String p1,
                         @RequestParam(value = "p2",required = false)String p2){
        return ">>>>>>hotkey is ready";
    }
    public String hotkeyhandler(String p1, String p2, BlockException exception){
        return ".....hotkey is failed o(╥﹏╥)o";
    }

}
