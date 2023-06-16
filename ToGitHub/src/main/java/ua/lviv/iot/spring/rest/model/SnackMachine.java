package ua.lviv.iot.spring.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SnackMachine {
    private Integer id;
    private String address;
    private List<String> menu;
    private List<String> existingTrademarkOfSnacks;
    private Map<String, Integer>  existingSnacks;
    private Map<String, Integer>  soldedSnacks;
}
