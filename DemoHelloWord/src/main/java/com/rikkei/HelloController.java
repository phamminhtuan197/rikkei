package com.rikkei;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//sử dụng annotation @RestController để đơn giản hóa việc tạo ra các RESTful web service. 
//Nó là sự kết hợp của annotaiton @Controller và @ResponseBody.
//sử dụng @RequestMapping để chỉ đường dẫn tới source chung là hello

@RestController
@RequestMapping(value = "/hello")
public class HelloController {
	@GetMapping
	public String printHello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!!", name);
	}
	//sử dụng annotation @GetMapping để đánh dấu phương thức này là GET.
	//@RequestParam annotation được sử dụng để trích xuất dữ liệu từ query parameters, form parameters,...
	//Ở trên mình đã sử dụng @RequestParam để ánh xạ giá trị của name trong query parameter như tham số truyền vào printHello().
}
