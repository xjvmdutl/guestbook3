package kr.co.itcen.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.itcen.guestbook.dao.GuestBookDao;
import kr.co.itcen.guestbook.vo.GuestBookVo;

@Controller
public class GuestbookController {
	@Autowired//스프링에서 쓰고 있는 어노테이션 , 자동으로 객체를 채워준다.//아직 컨테이너가 없기 떄문에 에러가 뜬다.
	private GuestBookDao guestbookDao;
	
	
	@RequestMapping({"","/list"})
	public String index(Model model) {
		List<GuestBookVo> list = guestbookDao.selectAll();
		model.addAttribute("list",list);
		return "/WEB-INF/views/index.jsp";
	}
}
