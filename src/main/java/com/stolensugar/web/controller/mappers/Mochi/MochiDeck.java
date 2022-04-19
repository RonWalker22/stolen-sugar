package com.stolensugar.web.controller.mappers.Mochi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "~:decks",
        "~:version",
        "~:templates"
})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class MochiDeck {

    @JsonProperty("~:decks")
    private @Getter @Setter List<Deck> decks = new ArrayList<>();
    @JsonProperty("~:version")
    private @Getter @Setter Integer version = 2;
    @JsonProperty("~:templates")
    private @Getter @Setter Templates templates;

}
