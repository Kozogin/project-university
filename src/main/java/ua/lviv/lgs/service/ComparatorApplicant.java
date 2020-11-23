package ua.lviv.lgs.service;

import java.util.Comparator;

import ua.lviv.lgs.domain.Applicant;

public class ComparatorApplicant implements Comparator<Applicant>{

	@Override
	public int compare(Applicant a1, Applicant a2) {
		if(a1.getPointsForBall() > a2.getPointsForBall()) {
			return -1;
		}
		if(a1.getPointsForBall() < a2.getPointsForBall()) {
			return 1;
		}
		return 0;
	}

}
