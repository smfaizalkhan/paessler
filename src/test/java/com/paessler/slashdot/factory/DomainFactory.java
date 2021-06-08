package com.paessler.slashdot.factory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainFactory {

    public static Map<String, List> getmapOfDateToNews(){
        Map<String, List> mapOfDateToNews = new HashMap<>();
        mapOfDateToNews.put("2015-12-31",
                Arrays.asList("New Maps Show Spread and Impact of Drought On California Forests 00",
                        "The Power of Crowds and Human Computation",
                        "Nadine the Robot Receptionist",
                        "Apple Faces $5 Million Lawsuit Over Allegedly Slowing the iPhone 4S With iOS 9 ",
                        "Oculus To Ship \"Lucky's Tale\" Game With Rift ",
                        "The E6-B Flight Computer Is 75 Years Old, Still In Use",
                        "Is Wikipedia's Popularity Causing Its Decline?",
                        "Dog With 3D-Printed Legs Gets an Upgrade ",
                        "Feds: Your Employer Can't Stop You From Recording Conversations At Work",
                        "Microsoft Makes a Selfie App For the iPhone",
                        "Last Operating Magnox Nuclear Reactor Closes ",
                        "George Lucas Criticizes the Force Awakens ",
                        "Should We Fill the Sahara With Solar Panels? ",
                        "The Winner-Take-All Trend In Tech",
                        "Tech Companies Face Criminal Charges If They Notify Users of UK Government Spying",
                        "Exploding Munitions Caught On Seismometer "));

        mapOfDateToNews.put("2015-12-30",
                Arrays.asList("NSA Cheerleaders Discover Value of Privacy Only When Their Own Is Violated",
                        "New York Begins Public Gigabit Wi-Fi Rollout",
                        "Lessig: Future Tech Will Help Privacy Catch Up With the Internet",
                        "Human Brain Still Beats Computers At Finding Messages and Meaning Within Noise",
                        "1st Circuit Injunction Re: TSA's New Mandatory AIT Search Rule Fully Briefed",
                        "Paramount and CBS File Lawsuit Against Crowdfunded, Indie Star Trek Movie",
                        "SpaceX To Test Recovered First Stage, Then Put It On Display",
                        "Debian Founder Ian Murdock Has Died",
                        "Twitter Bans 'Hateful Conduct'",
                        "List of Major Linux Desktop Problems Updated For 2016",
                        "Posture Affects Standing, and Not Just the Physical Kind",
                        "Open Source Roles: Starters vs. Maintainers",
                        "Physicists Figure Out How To Make Cleaner Fuel Cells",
                        "Coding Styles Survive Binary Compilation, Could Lead Investigators Back To Programmers",
                        "Apple Settles a $348M Fine With Italian Authorities For Tax Evasion",
                        "Emergency Room Visits From Distracted Walking Skyrocket 142",
                        "Chrome Extension Offers Trump-Free Browsing",
                        "Oracle Asked To Help Low-Income Residents Evicted For Its New Cloud Campus",
                        "The Paradox of Grey Hat Hackers",
                        "Publisher Is Pretty Sure Google Could End Piracy"));

        mapOfDateToNews.put("2021-06-08",
                Arrays.asList("New Maps Show Spread and Impact of Drought On California Forests 00",
                        "The Power of Crowds and Human Computation",
                        "Nadine the Robot Receptionist",
                        "Apple Faces $5 Million Lawsuit Over Allegedly Slowing the iPhone 4S With iOS 9 ",
                        "Oculus To Ship \"Lucky's Tale\" Game With Rift ",
                        "The E6-B Flight Computer Is 75 Years Old, Still In Use",
                        "Is Wikipedia's Popularity Causing Its Decline?",
                        "Dog With 3D-Printed Legs Gets an Upgrade ",
                        "Feds: Your Employer Can't Stop You From Recording Conversations At Work",
                        "Microsoft Makes a Selfie App For the iPhone",
                        "Last Operating Magnox Nuclear Reactor Closes ",
                        "George Lucas Criticizes the Force Awakens ",
                        "Should We Fill the Sahara With Solar Panels? ",
                        "The Winner-Take-All Trend In Tech",
                        "Tech Companies Face Criminal Charges If They Notify Users of UK Government Spying",
                        "Exploding Munitions Caught On Seismometer "));

        mapOfDateToNews.put("2021-06-07",
                Arrays.asList("NSA Cheerleaders Discover Value of Privacy Only When Their Own Is Violated",
                        "New York Begins Public Gigabit Wi-Fi Rollout",
                        "Lessig: Future Tech Will Help Privacy Catch Up With the Internet",
                        "Human Brain Still Beats Computers At Finding Messages and Meaning Within Noise",
                        "1st Circuit Injunction Re: TSA's New Mandatory AIT Search Rule Fully Briefed",
                        "Paramount and CBS File Lawsuit Against Crowdfunded, Indie Star Trek Movie",
                        "SpaceX To Test Recovered First Stage, Then Put It On Display",
                        "Debian Founder Ian Murdock Has Died",
                        "Twitter Bans 'Hateful Conduct'",
                        "List of Major Linux Desktop Problems Updated For 2016",
                        "Posture Affects Standing, and Not Just the Physical Kind",
                        "Open Source Roles: Starters vs. Maintainers",
                        "Physicists Figure Out How To Make Cleaner Fuel Cells",
                        "Coding Styles Survive Binary Compilation, Could Lead Investigators Back To Programmers",
                        "Apple Settles a $348M Fine With Italian Authorities For Tax Evasion",
                        "Emergency Room Visits From Distracted Walking Skyrocket 142",
                        "Chrome Extension Offers Trump-Free Browsing",
                        "Oracle Asked To Help Low-Income Residents Evicted For Its New Cloud Campus",
                        "The Paradox of Grey Hat Hackers",
                        "Publisher Is Pretty Sure Google Could End Piracy"));

        return mapOfDateToNews;
    }

    public static List<String> getNewsContent(){
        return    Arrays.asList("New Maps Show Spread and Impact of Drought On California Forests 00",
                "The Power of Crowds and Human Computation",
                "Nadine the Robot Receptionist",
                "Apple Faces $5 Million Lawsuit Over Allegedly Slowing the iPhone 4S With iOS 9 ",
                "Oculus To Ship \"Lucky's Tale\" Game With Rift ",
                "The E6-B Flight Computer Is 75 Years Old, Still In Use",
                "Is Wikipedia's Popularity Causing Its Decline?",
                "Dog With 3D-Printed Legs Gets an Upgrade ",
                "Feds: Your Employer Can't Stop You From Recording Conversations At Work",
                "Microsoft Makes a Selfie App For the iPhone",
                "Last Operating Magnox Nuclear Reactor Closes ",
                "George Lucas Criticizes the Force Awakens ",
                "Should We Fill the Sahara With Solar Panels? ",
                "The Winner-Take-All Trend In Tech",
                "Tech Companies Face Criminal Charges If They Notify Users of UK Government Spying",
                "Exploding Munitions Caught On Seismometer ");
    }
}
