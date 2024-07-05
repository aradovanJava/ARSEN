package hr.apisit.arsen;

import hr.apisit.arsen.model.Address;
import hr.apisit.arsen.model.Owner;
import hr.apisit.arsen.model.RealEstate;
import hr.apisit.arsen.repository.RepositoryGenerator;
import hr.apisit.arsen.thread.TheMostExpensiveRealEstateThread;
import hr.apisit.arsen.user.input.InputUtils;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Thread thread = new Thread(new TheMostExpensiveRealEstateThread());
        thread.start();

        List<Owner> ownerList =
            RepositoryGenerator.getOwnerRepository().findAll();

        List<Address> addressList =
            RepositoryGenerator.getAddressRepository().findAll();

        List<RealEstate> myRealEstates =
            RepositoryGenerator.getRealEstateRepository().findAll();

        RealEstate theMostExpensiveRealEstate = myRealEstates.stream()
                .max((re1, re2) -> re1.getPrice().compareTo(re2.getPrice()))
                .get();

        System.out.println("The most expensive real estate is " + theMostExpensiveRealEstate);

        Optional<RealEstate> theCheapestRealEstateOptional = myRealEstates.stream()
                .min((re1, re2) -> re1.getPrice().compareTo(re2.getPrice()));

        if(theCheapestRealEstateOptional.isPresent()) {
            RealEstate theCheapestRealEstate = theCheapestRealEstateOptional.get();
            System.out.println("The cheapest real estate is " + theCheapestRealEstate);
        }

        myRealEstates.stream()
                .map(rs -> rs.getAddress().getStreet())
                .sorted()
                .forEach(System.out::println);

        // unos nove vikendice

        Scanner input = new Scanner(System.in);

        System.out.print("Unesite broj vikendica koje želite unijeti: ");
        Integer cottageCount = input.nextInt();

        for(int i = 0; i < cottageCount; i++) {
            Address cottageAddress = InputUtils.chooseAddress(i, addressList, input);
            System.out.println("Odabrana je: " + cottageAddress);
        }


    }
}