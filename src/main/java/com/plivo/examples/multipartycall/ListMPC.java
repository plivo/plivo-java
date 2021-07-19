package com.plivo.examples.multipartycall;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.multipartycall.MultiPartyCall;
import com.plivo.api.models.multipartycall.MultiPartyCallUtils;
import com.plivo.api.util.PropertyFilter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ListMPC {

  private static boolean checkTime(String timeString) {
    return OffsetDateTime.parse(timeString, DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ssXXXXX")).isBefore(OffsetDateTime.now().minusHours(1));
  }

  public static void main(String[] args) throws IOException, PlivoRestException, PlivoValidationException, NoSuchMethodException {
    Plivo.init("<YOUR-AUTH-ID>", "<YOUR-AUTH-TOKEN>");

    // Fetch all MultiPartyCalls for an account
    ListResponse<MultiPartyCall> allMPC = MultiPartyCall.lister().list();
    System.out.println(allMPC.getMeta().getTotalCount());

    // Fetch only ended MultiPartyCalls for an account. Other possible status are (initialized, active)
    ListResponse<MultiPartyCall> endedMPC = MultiPartyCall.lister().status(MultiPartyCallUtils.ended).list();
    if (endedMPC.getObjects().stream().allMatch(mpc -> mpc.getStatus().equals(MultiPartyCallUtils.ended))) {
      System.out.println("fetched only ended MPC");
    } else {
      System.out.println("failed to fetch only ended MPC");
    }

    ListResponse<MultiPartyCall> previousHourMPC = MultiPartyCall.lister().
      endTime(new PropertyFilter<String>().lessThan(new SimpleDateFormat("yyyy-MM-dd hh:mm").
        format(new Date(System.currentTimeMillis() - 3600 * 1000)))).list();
    if (previousHourMPC.getObjects().stream().allMatch(mpc -> ListMPC.checkTime(mpc.getEndTime()))) {
      System.out.println("fetched only MPC older than 1 hour");
    } else {
      System.out.println("failed to fetch MPC older than 1 hour");
    }
  }
}
