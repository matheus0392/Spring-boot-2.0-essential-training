package dev.msnascimento.training;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThisWillActuallyRun {

	@RequestMapping("/")
	@ResponseBody
	String Home() {
		return "Hello World!";
	}
}
