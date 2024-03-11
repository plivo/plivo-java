package com.plivo.api;

import com.plivo.api.models.campaign.*;
import com.plivo.api.models.base.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class CampaignTest extends BaseTest {
    private PlivoClient client;
    @Before
    public void setUp() throws Exception {
        super.setUp();
        client = new PlivoClient("MA123456789012345678",
        "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    @Test
    public void campaignCreateShouldSucceed() throws Exception {
        String fixtureName = "campaignCreateResponse.json";

        expectResponse(fixtureName, 202);
        String[] sub_usecase = new String[]{"2FA", "MARKETING"};
        Campaign.creator("BCKWPKX", "java sdk camp create", "ENTERTAINMENT", "2FA", sub_usecase, "description", false,false, false, false, true, true,true, true, "sample1", "sample2", null,  null, "messageFlow should be minimum 40 char", "helpMessage is mandatory field","optoutMessage should be 40 char",  "optinKeywords", " optinMessage", "optoutKeywords", "helpKeywords").create();

        assertRequest("POST", "10dlc/Campaign/");
    }

    @Test
    public void campaignImportShouldSucceed() throws Exception {
        String fixtureName = "campaignImportResponse.json";

        expectResponse(fixtureName, 202);
        Campaign.importer("CNTQ0OD", "New Contact by vinay for ct").import_campaign();

        assertRequest("POST", "10dlc/Campaign/Import/");
    }

    @Test
    public void campaignUpdateShouldSucceed() throws Exception {
        String fixtureName = "campaignUpdateResponse.json";

        expectResponse(fixtureName, 202);
        
        CampaignUpdateResponse response = Campaign.updater("CY5NVUA","","","sample1 updated","","","","","","","","").client(client).update();
        assertEquals("CY5NVUA", response.getCampaign().getCampaignID());

        assertRequest("POST", "10dlc/Campaign/%s/", "CY5NVUA");
        assertEquals("CY5NVUA", response.getCampaign().getCampaignID());
    }

    @Test
    public void campaignGetShouldSucceed() throws Exception {
        String fixtureName = "campaignGetResponse.json";

        expectResponse(fixtureName, 202);
        String campaignID = "CY5NVUA";
        Boolean embeddedLink = false;

        Campaign response = Campaign.getter(campaignID).get();

        assertRequest("GET", "10dlc/Campaign/%s/", campaignID);
        assertEquals(campaignID, response.getCampaign().getCampaignID());
        assertEquals(embeddedLink, response.getCampaign().getCampaignAttributes().getEmbeddedLink());
    }

    @Test
    public void campaignListShouldSucceed() throws Exception {
        String fixtureName = "campaignListResponse.json";

        expectResponse(fixtureName, 202);
        ListResponse<Campaign> response = Campaign.lister().limit(2).offset(0).list();

        assertRequest("GET", "10dlc/Campaign/");
    }

    @Test
    public void campaignNumberLinkShouldSucceed() throws Exception {
        String fixtureName = "campaignNumberLinkResponse.json";

        expectResponse(fixtureName, 202);
        String campaignID = "C9PDW4R";
        String[] numbers = new String[]{"14845197515"};
        CampaignNumberLinkerResponse response = CampaignNumbers.link(campaignID,null, null, numbers).create();

        assertRequest("POST", "10dlc/Campaign/%s/Number/",campaignID);
    }

    @Test                                                                                           
    public void campaignGetNumbersShouldSucceed() throws Exception {                                
        String fixtureName = "campaignGetNumbersResponse.json";                                     
                                                                                                    
        expectResponse(fixtureName, 202);                                                           
        String campaignID = "CRIGC80";
        String number = "14845007032";
        Integer phoneNumbersCompletedStatusCount = 1;                                                   
        CampaignNumbers response = CampaignNumbers.getNumbers(campaignID).limit(2).offset(0).get();
        Integer numberPoolLimit = 49;
                                                                                                    
        assertRequest("GET", "10dlc/Campaign/%s/Number/",campaignID);      
        assertEquals(campaignID, response.getCampaignID());                         
        assertEquals(number, response.getPhoneNumbers()[0].getNumber());                         
        assertEquals(phoneNumbersCompletedStatusCount, response.getPhoneNumbersSummary().get("COMPLETED"));                         
        assertEquals(numberPoolLimit, response.getNumberPoolLimit());                         
        
    }                                                                                               
                                                                                                    
   @Test                                                                                            
    public void campaignNumberUnlinkShouldSucceed() throws Exception {                              
        String fixtureName = "campaignNumberUnlinkResponse.json";                                  
                                                                                                    
        expectResponse(fixtureName, 202);                                                           
        CampaignNumbers response = CampaignNumbers.unlink("C9PDW4R", "14845071194", null, null).delete();
                                                                                                         
        assertRequest("DELETE", "10dlc/Campaign/C9PDW4R/Number/14845071194/");                           
    }

    @Test
    public void campaignDeleteShouldSucceed() throws Exception {
        String fixtureName = "campaignDeleteResponse.json";
        String campaignID = "CXXX";

        expectResponse(fixtureName, 202);
        CampaignDeleteResponse response = Campaign.deleter(campaignID).delete();

        assertRequest("DELETE", "10dlc/Campaign/CXXX/");
        assertEquals("Campaign Deactivated", response.getMessage());
        assertEquals("CXXX", response.getCampaignId());
    }

}
