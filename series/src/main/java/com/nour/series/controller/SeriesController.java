package com.nour.series.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import com.nour.series.entites.Series;
import com.nour.series.service.SeriesService;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
public class SeriesController {

	@Autowired
	private SeriesService serieService;

	@GetMapping(value = "/")
	public String welcome() {
		return "index";
	}

	@RequestMapping("/myView")
	public String myView() {
		return "myView";
	}

	@RequestMapping("/ListeSeries")
	public String listeSeries(ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Series> series = serieService.getAllSeriesParPage(page, size);
		modelMap.addAttribute("series", series);
		modelMap.addAttribute("pages", new int[series.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeSeries";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		modelMap.addAttribute("series", new Series());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("pays", serieService.getAllPays());
		return "formSerie";
	}

	@RequestMapping("/saveSerie")
	public String saveSerie(@Valid @ModelAttribute("series") Series series, BindingResult bindingResult,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size,
			ModelMap modelMap) {
		int currentPage;
		boolean isNew = false;

		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("pays", serieService.getAllPays());
			return "formSerie";
		}

		if (series.getCodeSerie() == null) 
			isNew = true;

		serieService.saveSeries(series);

		if (isNew) 
		{
			Page<Series> prods = serieService.getAllSeriesParPage(page, size);
			currentPage = prods.getTotalPages() - 1;
		} else 
			currentPage = page;

		return ("redirect:/ListeSeries?page=" + currentPage + "&size=" + size);
	}

	@RequestMapping("/supprimerSerie")
	public String supprimerSerie(@RequestParam("id") Long id,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size,
			ModelMap modelMap) {
		serieService.deleteSeriesById(id);
		Page<Series> series = serieService.getAllSeriesParPage(page, size);
		modelMap.addAttribute("series", series);
		modelMap.addAttribute("pages", new int[series.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeSeries";
	}

	@RequestMapping("/modifierSerie")
	public String editerSerie(@RequestParam("id") Long id,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size,
			ModelMap modelMap) {
		Series s = serieService.getSeries(id);
		modelMap.addAttribute("series", s);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("pays", serieService.getAllPays());
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		return "formSerie";
	}
}