package kr.co.itcen.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping("/delete/{no}")
	public String delete(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no",no);
		return "/WEB-INF/views/delete.jsp";
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(@ModelAttribute GuestBookVo vo) {
		guestbookDao.delete(vo);
		return "redirect:/";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@ModelAttribute GuestBookVo vo) {
		
		guestbookDao.insert(vo);
		return "redirect:/";
	}
}
