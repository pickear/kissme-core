package com.kissme.core.helper;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.collect.Lists;

/**
 * 
 * @author loudyn
 * 
 */
public final class RichHtmlHelper {

	/**
	 * 
	 * @param html
	 * @return
	 */
	public static List<String> populatePhotos(String html) {

		if (StringUtils.isBlank(html)) {
			return Collections.emptyList();
		}

		Document doc = Jsoup.parse(html);
		Elements eles = doc.select("img[src]");
		if (eles.isEmpty()) {
			return Collections.emptyList();
		}

		List<String> photos = Lists.newLinkedList();
		for (Element ele : eles) {
			photos.add(ele.attr("src"));
		}

		return photos;
	}

	/**
	 * 
	 * @param html
	 * @return
	 */
	public static List<String> populateFlashes(String html) {
		if (StringUtils.isBlank(html)) {
			return Collections.emptyList();
		}

		Document doc = Jsoup.parse(html);
		Elements eles = doc.select("embed[src][type$=flash]");
		if (eles.isEmpty()) {
			return Collections.emptyList();
		}

		List<String> flashes = Lists.newLinkedList();
		for (Element ele : eles) {
			flashes.add(ele.attr("src"));
		}

		return flashes;
	}

	private RichHtmlHelper() {}
}
