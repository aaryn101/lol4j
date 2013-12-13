package lol4j.protocol.resource;

import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.summoner.MasteryPagesDto;
import lol4j.util.Region;

/**
 * Created by Aaryn101 on 12/12/13.
 */
public interface SummonerResource {
    MasteryPagesDto getMasteryPages(Region region, long summonerId) throws InvalidRegionException;
}
