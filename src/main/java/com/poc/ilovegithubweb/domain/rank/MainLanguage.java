package com.poc.ilovegithubweb.domain.rank;

import lombok.Data;

@Data
public class MainLanguage {

	private String firstLanguage;
	private String secondLanguage;
	private String thirdLanguage;
	//
	//    public static MainLanguage getMainLanguage(UserRank userRank) {
	//        String[] languageSet = userRank.getMainLanguage().split(",");
	//        return parseMainLanguage(languageSet);
	//    }
	//
	//    public static MainLanguage getMainLanguage(OrgRank orgRank) {
	//        String[] languageSet = orgRank.getMainLanguage().split(",");
	//        return parseMainLanguage(languageSet);
	//    }
	//
	//    private static MainLanguage parseMainLanguage(String[] languageSet) {
	//        MainLanguage resultLanguage = new MainLanguage();
	//        if(languageSet.length > 0) resultLanguage.setFirstLanguage(languageSet[0]);
	//        if(languageSet.length > 1) resultLanguage.setSecondLanguage(languageSet[1]);
	//        if(languageSet.length > 2) resultLanguage.setThirdLanguage(languageSet[2]);
	//        return resultLanguage;
	//    }
}
