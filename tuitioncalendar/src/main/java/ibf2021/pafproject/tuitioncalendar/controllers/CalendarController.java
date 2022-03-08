package ibf2021.pafproject.tuitioncalendar.controllers;

// import java.io.File;
// import java.io.IOException;
// import java.net.URL;
// import java.security.GeneralSecurityException;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.HashSet;
// import java.util.Set;

// import javax.servlet.http.HttpServletRequest;

// import com.google.api.client.auth.oauth2.Credential;
// import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
// import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
// import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
// import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
// import com.google.api.client.http.HttpTransport;
// import com.google.api.client.json.JsonFactory;
// import com.google.api.client.json.jackson2.JacksonFactory;
// import com.google.api.client.repackaged.com.google.common.base.Preconditions;
// import com.google.api.client.repackaged.com.google.common.base.Strings;
// import com.google.api.client.util.DateTime;
// import com.google.api.services.calendar.CalendarScopes;
// import com.google.api.services.calendar.Calendar.Events;
// import com.google.api.services.calendar.model.Event;
// import com.google.api.services.calendar.model.EventDateTime;
// import com.google.api.services.calendar.model.EventReminder;

// import org.apache.commons.logging.Log;
// import org.apache.commons.logging.LogFactory;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.RequestMapping;
// // import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class CalendarController {

//     private final static Log logger = LogFactory.getLog(CalendarController.class);
//     private static final String APPLICATION_NAME = "serviceCal";
//     private static HttpTransport httpTransport;
//     private static final JsonFactory JSON_FACTORY = new JacksonFactory();
//     private static com.google.api.services.calendar.Calendar client;

//     URL url = getClass().getResource("auth.p12");
//     File keyFile = new File(url.getPath());
//     GoogleClientSecrets clientSecrets;
//     GoogleAuthorizationCodeFlow flow;
//     Credential credential;

//     HttpTransport TRANSPORT;
//     private String SERVICE_ACCOUNT = "tuition-scheduling-assistant@tuition-scheduler.iam.gserviceaccount.com";

    // private Set<Event> events = new HashSet<>();

    // public void setEvents(Set<Event> events) {
    //     this.events = events;
    // }

//     @RequestMapping(value = "/add", method = RequestMethod.GET)
//     public ResponseEntity<String> oauth2Callback(HttpServletRequest request)
//             throws IOException, GeneralSecurityException {
//         com.google.api.services.calendar.model.Events eventList;
//         String message;

//         // TokenResponse response =
//         // flow.newTokenRequest(code).setRedirectUri(redirectURI).execute();
//         // credential = flow.createAndStoreCredential(response, "userID"); //for Oauth2
//         Preconditions.checkArgument(!Strings.isNullOrEmpty(APPLICATION_NAME),
//                 "applicationName cannot be null or empty!");
//         try {
//             TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

//             credential = new GoogleCredential.Builder().setTransport(TRANSPORT)
//                     .setJsonFactory(JSON_FACTORY)
//                     .setServiceAccountId(SERVICE_ACCOUNT)
//                     .setServiceAccountScopes(Collections.singleton(CalendarScopes.CALENDAR))
//                     .setServiceAccountPrivateKeyFromP12File(keyFile)

//                     .build();
//             credential.refreshToken();
//             client = new com.google.api.services.calendar.Calendar.Builder(TRANSPORT, JSON_FACTORY, credential)
//                     .setApplicationName(APPLICATION_NAME).build();
//             System.out.println(client);
//             Events events = client.events();
            
//         eventList = events.list("primary").execute();
//             message = eventList.getItems().toString();

//             Event event = new Event()
//                     .setSummary("Google I/O 2015")
//                     .setLocation("800 Howard St., San Francisco, CA 94103")
//                     .setDescription("A chance to hear more about Google's developer products.");

//             DateTime startDateTime = new DateTime("2021-07-31T09:00:00-07:00");
//             EventDateTime start = new EventDateTime()
//                     .setDateTime(startDateTime)
//                     .setTimeZone("America/Los_Angeles");
//             event.setStart(start);

//             DateTime endDateTime = new DateTime("2021-08-01T17:00:00-07:00");
//             EventDateTime end = new EventDateTime()
//                     .setDateTime(endDateTime)
//                     .setTimeZone("America/Los_Angeles");
//             event.setEnd(end);

//             String[] recurrence = new String[] { "RRULE:FREQ=DAILY;COUNT=2" };
//             event.setRecurrence(Arrays.asList(recurrence));
//             // EventAttendee[] attendees = new EventAttendee[] {
//             // new EventAttendee().setEmail("greatgatsbylala18@gmail.com"),
//             // new EventAttendee().setEmail("himanshuranjan3030@gmail.com"),
//             // };
//             // event.setAttendees(Arrays.asList(attendees));

//             EventReminder[] reminderOverrides = new EventReminder[] {
//                     new EventReminder().setMethod("email").setMinutes(24 * 60),
//                     new EventReminder().setMethod("popup").setMinutes(10),
//             };
//             Event.Reminders reminders = new Event.Reminders()
//                     .setUseDefault(false)
//                     .setOverrides(Arrays.asList(reminderOverrides));
//             event.setReminders(reminders);

//             String calendarId = "primary";
//             event = client.events().insert("putyouremailhere@gmail.com", event).execute();
//             System.out.printf("Event created: %s\n", event.getHtmlLink());

//             System.out.println("cal message:" + message);
//             return new ResponseEntity<>(message, HttpStatus.OK);
//         } catch (IOException e) {
//             System.out.println(e);
//         }
//         return new ResponseEntity<>("Nothing", HttpStatus.OK);
//     }

//     public Set<Event> getEvents() throws IOException {
//         return this.events;
//     }

// }
