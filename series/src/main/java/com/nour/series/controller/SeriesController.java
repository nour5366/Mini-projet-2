package com.nour.series.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import com.nour.series.entites.Series;
import com.nour.series.service.SeriesService;

@Controller
public class SeriesController {

	@Autowired
	private SeriesService serieService;

	@RequestMapping("/myView")
	public String myView() {
		return "myView";
	}

	// Liste des séries avec pagination
	@RequestMapping("/ListeSeries")
	public String listeSeries(ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Series> series = serieService.getAllSeriesParPage(page, size);
		modelMap.addAttribute("series", series);
		modelMap.addAttribute("pages", new int[series.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeSeries"; // fichier listeSeries.html
	}

	// Afficher formulaire création
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createSerie"; // fichier createSerie.html
	}

	// Sauvegarder une nouvelle série
	@RequestMapping("/saveSerie")
	public String saveSerie(@ModelAttribute("serie") Series serie, @RequestParam("date") String date, ModelMap modelMap)
			throws ParseException {

		// Conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateLancement = dateformat.parse(date);
		serie.setDateLancement(dateLancement);
		Series savedSerie = serieService.saveSeries(serie);
		String msg = "Serie enregistrée avec Id " + savedSerie.getCodeSerie();
		modelMap.addAttribute("msg", msg);
		return "createSerie";
	}

	// Supprimer une série
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

	// Modifier une série
	@RequestMapping("/modifierSerie")
	public String editerSerie(@RequestParam("id") Long id, ModelMap modelMap) {
		Series s = serieService.getSeries(id);
		modelMap.addAttribute("serie", s);
		return "editerSerie"; // fichier editerSerie.html
	}

	// Mettre à jour une série
	@RequestMapping("/updateSerie")
	public String updateSerie(@ModelAttribute("serie") Series serie, @RequestParam("date") String date,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size,
			ModelMap modelMap) throws ParseException {

		// Conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateLancement = dateformat.parse(date);
		serie.setDateLancement(dateLancement);

		serieService.updateSeries(serie);
		Page<Series> series = serieService.getAllSeriesParPage(page, size);
		modelMap.addAttribute("series", series);
		modelMap.addAttribute("pages", new int[series.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeSeries";
	}
}