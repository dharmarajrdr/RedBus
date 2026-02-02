package com.dharmaraj.redbus.dtos.response;

import com.dharmaraj.redbus.enums.SortOrder;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginatedResponse<S, D extends RowToDtoConverter<S, D>> {

    private List<D> data;

    private Integer totalPages;

    private SortOrder sort;

    private Integer page;

    private Integer size;

    public static <S, D extends RowToDtoConverter<S, D>> PaginatedResponse<S, D> fromPageConvertTo(Page<S> page, Class<D> dtoClass) {

        List<D> dtoList = page.getContent().stream().map(row -> {
            try {
                return dtoClass.getDeclaredConstructor().newInstance().convert(row);
            } catch (Exception e) {
                throw new RuntimeException("DTO Conversion failed for: " + dtoClass.getSimpleName(), e);
            }
        }).toList();

        return PaginatedResponse.<S, D>builder()
                .data(dtoList)
                .totalPages(page.getTotalPages())
                .page(page.getNumber())
                .size(page.getSize())
                .build();
    }

}
