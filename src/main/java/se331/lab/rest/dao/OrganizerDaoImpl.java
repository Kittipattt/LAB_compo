package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> OrganizerList;

    @PostConstruct
    public void init() {
        OrganizerList = new ArrayList<>();
        OrganizerList.add(Organizer.builder()
                .id(1233232L)
                .category("animal welfare")
                .title("Cat Adoption Day")
                .description("Find your new feline friend at this event.")
                .location("Meow Town")
                .date("January 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .organizer("Kat Laydee")
                .build());
        OrganizerList.add(Organizer.builder()
                .id(45126L)
                .category("food")
                .title("Community Gardening")
                .description("Join us as we tend to the community edible plants.")
                .location("Flora City")
                .date("March 14, 2022")
                .time("10:00")
                .petAllowed(true)
                .organizer("Fern Pollin")
                .build());
        OrganizerList.add(Organizer.builder()
                .id(78233L)
                .category("sustainability")
                .title("Beach Cleanup")
                .description("Help pick up trash along the shore.")
                .location("Playa Del Carmen")
                .date("July 22, 2022")
                .time("11:00")
                .petAllowed(false)
                .organizer("Carey Wales")
                .build());
        OrganizerList.add(Organizer.builder()
                .id(123442L)
                .category("animal welfare")
                .title("Dog Adoption Day")
                .description("Find your new canine friend at this event.")
                .location("Woof Town")
                .date("August 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .organizer("Dawg Dahd")
                .build());
        OrganizerList.add(Organizer.builder()
                .id(233433L)
                .category("food")
                .title("Canned Food Drive")
                .description("Bring your canned food to donate to those in need.")
                .location("Tin City")
                .date("September 14, 2022")
                .time("3:00")
                .petAllowed(true)
                .organizer("Kahn Opiner")
                .build());
        OrganizerList.add(Organizer.builder()
                .id(134432L)
                .category("sustainability")
                .title("Highway Cleanup")
                .description("Help pick up trash along the highway.")
                .location("Highway 50")
                .date("July 22, 2022")
                .time("11:00")
                .petAllowed(false)
                .organizer("Brody Kill")
                .build());
        // Add more events if needed
    }

    // Other methods of EventDao interface, if any
    @Override
    public Integer getOrganizerSize() {

        return OrganizerList.size();
    }

    @Override
    public List<Organizer> getOrganizer(Integer pageSize, Integer page) {
        int firstIndex = (page - 1)*pageSize;
        return OrganizerList.subList(firstIndex,firstIndex+pageSize);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return OrganizerList.stream().filter(Organizer ->
                Organizer.getId().equals(id)).findFirst().orElse(null);
    }
}
