package com.nish.project.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageResponseDto<T> {

	private List<T> content;

	private int pageNumber;

	private int pageSize;

	private long totalElements;

	private int totalPages;

	private boolean lastPage;
}