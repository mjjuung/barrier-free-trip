package com.example.barrierfreetrip.touristfacility.controller;

import com.example.barrierfreetrip.touristfacility.dto.TouristFacility;
import com.example.barrierfreetrip.touristfacility.dto.TouristFacilityInfoResponseDto;
import com.example.barrierfreetrip.touristfacility.dto.TouristFacilityListResponseDto;
import com.example.barrierfreetrip.touristfacility.service.TouristFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TouristFacilityController {
    private final TouristFacilityService touristFacilityService;

    /**
     * 관광 시설 리스트 리턴 api
     * @param contentTypeId
     * @param areaCode
     * @param sigunguCode
     * @return
     */
    @GetMapping("/tourist-facility-list/{contentTypeId}/{areaCode}/{sigunguCode}")
    public ResponseEntity returnTouristList(@PathVariable("contentTypeId") String contentTypeId,
                                            @PathVariable("areaCode") String areaCode,
                                            @PathVariable("sigunguCode") String sigunguCode
                                            ) {

        List<TouristFacility> touristFacilities = touristFacilityService.
                findByCode(contentTypeId, areaCode, sigunguCode);

        List<TouristFacilityListResponseDto> result = touristFacilities.stream()
                .map(tf -> new TouristFacilityListResponseDto(tf.getContentId(), tf.getContentId(),
                        tf.getTitle(), tf.getAddr1(), tf.getRating(), tf.getFirstimage()))
                .collect(Collectors.toList());


        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    @GetMapping("/tourist-facility-info/{memberId}/{contentId}")
    public ResponseEntity returnTouristInfo(@PathVariable("memberId") Long memberId,
                                            @PathVariable("contentId") String contentId) {
        TouristFacilityInfoResponseDto result = touristFacilityService.returnInfoDto(memberId, contentId);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}