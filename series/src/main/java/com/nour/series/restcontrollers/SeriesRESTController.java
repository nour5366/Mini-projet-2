package com.nour.series.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.nour.series.entites.Series;
import com.nour.series.service.SeriesService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SeriesRESTController {

    @Autowired
    SeriesService seriesService;

    @RequestMapping(value="/all",method = RequestMethod.GET)
    public List<Series> getAllSeries() {
        return seriesService.getAllSeries();
    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Series getSeriesById(@PathVariable("id") Long id) {
        return seriesService.getSeries(id);
    }

    @RequestMapping(value="/addserie",method = RequestMethod.POST)
    public Series createSeries(@RequestBody Series series) {
        return seriesService.saveSeries(series);
    }

    @RequestMapping(value="/updateserie",method = RequestMethod.PUT)
    public Series updateSeries(@RequestBody Series series) {
        return seriesService.updateSeries(series);
    }

    @RequestMapping(value = "/delserie/{id}", method = RequestMethod.DELETE)
    public void deleteSeries(@PathVariable("id") Long id) {
        seriesService.deleteSeriesById(id);
    }

    @RequestMapping(value = "/seriespays/{idPays}", method = RequestMethod.GET)
    public List<Series> getSeriesByPaysId(@PathVariable("idPays") Long idPays) {
        return seriesService.findByPaysCodePays(idPays);
    }

    @RequestMapping(value="/seriesByTitre/{titre}",method = RequestMethod.GET)
    public List<Series> findByTitreSerieContains(@PathVariable("titre") String titre) {
        return seriesService.findByTitreSerieContains(titre);
    }
}
