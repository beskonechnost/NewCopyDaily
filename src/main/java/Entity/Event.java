package Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Андрей on 26.01.2018.
 */
public class Event {

    private int codeFilial;
    private int idEvent;
    private Date eventDate;
    private int eventTypeId;
    private int employeeId;
    private String timeStampField;
    private String eventText;
    private String comment;

    public Event() {
    }
    public Event(int codeFilial, int idEvent, Date eventDate, int eventTypeId, int employeeId, String timeStampField, String eventText, String comment) {
        this.codeFilial = codeFilial;
        this.idEvent = idEvent;
        this.eventDate = eventDate;
        this.eventTypeId = eventTypeId;
        this.employeeId = employeeId;
        this.timeStampField = timeStampField;
        this.eventText = eventText;
        this.comment = comment;
    }

    public int getCodeFilial() {
        return codeFilial;
    }
    public void setCodeFilial(int codeFilial) {
        this.codeFilial = codeFilial;
    }

    public int getIdEvent() {
        return idEvent;
    }
    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public Date getEventDate() {
        return eventDate;
    }
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
    public void setEventDate(String dateEvent) {
        try {
            if(dateEvent.equals("30.12.1899")){
                this.eventDate = null;
            }else {
                this.eventDate = new SimpleDateFormat("dd.MM.yyyy").parse(dateEvent);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getEventTypeId() {
        return eventTypeId;
    }
    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getTimeStampField() {
        return timeStampField;
    }
    public void setTimeStampField(String timeStampField) {
        this.timeStampField = timeStampField;
    }

    public String getEventText() {
        return eventText;
    }
    public void setEventText(String eventText) {
        this.eventText = eventText;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Event{" +
                "codeFilial=" + codeFilial +
                ", idEvent=" + idEvent +
                ", eventDate=" + eventDate +
                ", eventTypeId=" + eventTypeId +
                ", employeeId=" + employeeId +
                ", timeStampField='" + timeStampField + '\'' +
                ", eventText='" + eventText + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
