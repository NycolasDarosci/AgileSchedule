package br.com.agileschedule.entity.retorno;

import java.util.ArrayList;
import java.util.List;

import br.com.agileschedule.entity.CourseProgress;
import br.com.agileschedule.entity.Guides;

public class CourseGuide {

    private Long id;
    private List<CourseProgress> courseProgress = new ArrayList<>();
    private List<Guides> guides = new ArrayList<>();

}
