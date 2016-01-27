/**
 * 
 */
package nl.rug.tdconfession.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import nl.rug.tdconfession.domain.Confession;
import nl.rug.tdconfession.service.ConfessionService;

/**
 * @author Georgios Digkas <digasgeo@yahoo.gr>
 *
 */
@Controller
public class ConfessionController {

	private static final String REDIRECT_HOME = "redirect:/";
	private static final String RIGHT_CONFESSIONS = "rightConfessions";
	private static final String LEFT_CONFESSIONS = "leftConfessions";
	private ConfessionService confessionService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<Confession> confessionList = confessionService.findAll();

		model.addAttribute(LEFT_CONFESSIONS, leftConfessions(confessionList));
		model.addAttribute(RIGHT_CONFESSIONS, rightConfessions(confessionList));
		return "home";
	}

	@RequestMapping(value = "/thumbsUp/{id}", method = RequestMethod.GET)
	public String thumbsUp(@PathVariable(value="id") int id) {
		Confession confession = confessionService.findById(id);
		confession.setPossitiveVotes(confession.getPossitiveVotes() + 1);
		confessionService.update(confession);

		return REDIRECT_HOME;
	}

	@RequestMapping(value = "/thumbsDown/{id}", method = RequestMethod.GET)
	public String thumbsDown(@PathVariable(value="id") int id) {
		Confession confession = confessionService.findById(id);
		confession.setNegativeVotes(confession.getNegativeVotes() + 1);
		confessionService.update(confession);

		return REDIRECT_HOME;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String createConfession(Locale locale, @RequestParam(value="confessionText") String confessionText) {		
		Confession confession = new Confession();
		confession.setConfessionText(confessionText);
		confession.setLocale(locale.toString());
		confession.setPossitiveVotes(0);
		confession.setNegativeVotes(0);
		confession.setPosted(new Date());
		confessionService.insert(confession);

		return REDIRECT_HOME;
	}

	@Autowired(required=true)
	public void setConfessionService(ConfessionService confessionService) {
		this.confessionService = confessionService;
	}

	private List<Confession> leftConfessions(List<Confession> confessionList) {
		List<Confession> leftConfessions = new ArrayList<>();

		if (!confessionList.isEmpty()) {
			int to = calculateTo(confessionList.size());
			for (int i = 0; i < to; i++) {
				leftConfessions.add(confessionList.get(i));
			}
		}
		return leftConfessions;
	}

	private List<Confession> rightConfessions(List<Confession> confessionList) {
		List<Confession> rightConfessions = new ArrayList<>();

		if (!confessionList.isEmpty()) {
			int to = calculateTo(confessionList.size());
			for (int i = to; i < confessionList.size(); i++) {
				rightConfessions.add(confessionList.get(i));
			}
		}
		return rightConfessions;
	}

	private int calculateTo(int size) {
		if (size % 2 == 0)
			return size / 2;
		return size / 2 + 1;
	}

}
