package Booking;

public class masterTicket extends AssignTicketType {
    
    private Boolean master = true;

    public masterTicket(TicketType ticket) {
        super(ticket);
    }
    
    @Override
	public void assign(){
		super.assign();

	}

    public void setMaster(Boolean master) {
        this.master = master;
    }

    public Boolean getMaster() {
        return master;
    }
}
