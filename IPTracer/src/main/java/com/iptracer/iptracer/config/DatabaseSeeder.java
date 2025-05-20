package com.iptracer.iptracer.config;

import com.iptracer.iptracer.model.Currency;
import com.iptracer.iptracer.repository.ICurrencyRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class DatabaseSeeder {
    private final ICurrencyRepository currencyRepository;

    @PostConstruct
    public void seed(){
        if(currencyRepository.count() == 0){
            currencyRepository.save(new Currency(1,"Martinique","EUR"," euro"));
            currencyRepository.save(new Currency(2,"Afghanistan","AFN"," Afghani Afghan"));
            currencyRepository.save(new Currency(3,"South Africa","ZAR"," South African Rand"));
            currencyRepository.save(new Currency(4,"Albania","ALL"," in Albanian"));
            currencyRepository.save(new Currency(5,"Germany","EUR"," euro"));
            currencyRepository.save(new Currency(6,"Andorra","EUR"," euro"));
            currencyRepository.save(new Currency(7,"Angola","AOA"," first angoleño"));
            currencyRepository.save(new Currency(8,"Anguilla","XCD"," dollar"));
            currencyRepository.save(new Currency(9,"Antigua and Barbuda","XCD"," dollar"));
            currencyRepository.save(new Currency(10,"Netherlands Antilles","XCG"," Caribbean Florin"));
            currencyRepository.save(new Currency(11,"Saudi Arabia","SAR"," Saudi riyal"));
            currencyRepository.save(new Currency(12,"Algeria","DZD"," Algerian dinar"));
            currencyRepository.save(new Currency(13,"Argentina","ARS"," Argentine peso"));
            currencyRepository.save(new Currency(14,"Armenia","AMD"," dram armenia"));
            currencyRepository.save(new Currency(15,"Aruba","AWG"," Aruban florin"));
            currencyRepository.save(new Currency(16,"Australia","AUD"," Australian dollar"));
            currencyRepository.save(new Currency(17,"Austria","EUR"," euro"));
            currencyRepository.save(new Currency(18,"Azerbaijan","AZN"," Azerbaijani manat"));
            currencyRepository.save(new Currency(19,"Bahamas","BSD"," Bahamian dollar"));
            currencyRepository.save(new Currency(20,"Bahrain","BHD"," Bahraini dinar"));
            currencyRepository.save(new Currency(21,"Bangladesh","BDT"," taka"));
            currencyRepository.save(new Currency(22,"Barbados","BBD"," dollar"));
            currencyRepository.save(new Currency(23,"Belgium","EUR"," euro"));
            currencyRepository.save(new Currency(24,"Belize","BZD"," dollar"));
            currencyRepository.save(new Currency(25,"Benin","XOF"," CFA franc"));
            currencyRepository.save(new Currency(26,"Bermuda","BMD"," dollar"));
            currencyRepository.save(new Currency(27,"Bhutan","BTN"," ngultrum"));
            currencyRepository.save(new Currency(28,"Belarus","BYN"," Belarusian ruble"));
            currencyRepository.save(new Currency(29,"Birmania (Myanmar)","MMK"," Burmese kyat"));
            currencyRepository.save(new Currency(30,"Bolivia","BOB"," boliviano"));
            currencyRepository.save(new Currency(31,"Bosnia and Herzegovina","BAM"," marco convertible"));
            currencyRepository.save(new Currency(32,"Botswana","BWP"," too"));
            currencyRepository.save(new Currency(33,"Brazil","BRL"," Brazilian real"));
            currencyRepository.save(new Currency(34,"Brunei","BND"," dollar"));
            currencyRepository.save(new Currency(35,"Bulgaria","BGN"," Bulgarian lev"));
            currencyRepository.save(new Currency(36,"Burkina Faso","XOF"," CFA franc"));
            currencyRepository.save(new Currency(37,"Burundi","BIF"," Burundian franc"));
            currencyRepository.save(new Currency(38,"Cape Verde","CVE"," Cape Verdean shield"));
            currencyRepository.save(new Currency(39,"Camboya","KHR"," Cambodian riel"));
            currencyRepository.save(new Currency(40,"Cameroon","XAF"," CFA franc"));
            currencyRepository.save(new Currency(41,"Canada","CAD"," Canadian dollar"));
            currencyRepository.save(new Currency(42,"Caribbean","XCG"," Caribbean Florin"));
            currencyRepository.save(new Currency(43,"Chad","XAF"," CFA franc"));
            currencyRepository.save(new Currency(44,"Chile","CLP"," Chilean peso"));
            currencyRepository.save(new Currency(45,"China","CNY"," RMB yuan renminbi chino"));
            currencyRepository.save(new Currency(46,"Cyprus","EUR"," euro"));
            currencyRepository.save(new Currency(47,"Vatican City","EUR"," euro"));
            currencyRepository.save(new Currency(48,"Colombia","COP"," Colombian peso"));
            currencyRepository.save(new Currency(49,"Comoros","Fra","nco-Comorian KMF"));
            currencyRepository.save(new Currency(50,"Congo (Brazzaville)","XAF"," CFA franc"));
            currencyRepository.save(new Currency(51,"Congo/Kinshasa (DRC)","Fra","nco-Congolese CDF"));
            currencyRepository.save(new Currency(52,"North Korea","KPW"," North Korean won"));
            currencyRepository.save(new Currency(53,"South Korea","KRW"," won surcoreano"));
            currencyRepository.save(new Currency(54,"Ivory Coast","XOF"," CFA franc"));
            currencyRepository.save(new Currency(55,"Costa Rica","Cos","ta Rican Colon CRC"));
            currencyRepository.save(new Currency(56,"Croatia","EUR"," euro"));
            currencyRepository.save(new Currency(57,"Cuba","CUC"," Cuban convertible peso (->CUP)"));
            currencyRepository.save(new Currency(58,"Curaçao","XCG"," Caribbean Florin"));
            currencyRepository.save(new Currency(59,"Denmark","DKK"," Danish krone"));
            currencyRepository.save(new Currency(60,"Dominique","XCD"," dollar"));
            currencyRepository.save(new Currency(61,"Ecuador","USD"," US dollar"));
            currencyRepository.save(new Currency(62,"Egypt","EGP"," Egyptian pound"));
            currencyRepository.save(new Currency(63,"United Arab Emirates","AED"," dirham"));
            currencyRepository.save(new Currency(64,"Eritrea","ERN"," Eritrean nafka"));
            currencyRepository.save(new Currency(65,"Slovakia","EUR"," euro"));
            currencyRepository.save(new Currency(66,"Slovenia","EUR"," euro"));
            currencyRepository.save(new Currency(67,"Spain","EUR"," euro"));
            currencyRepository.save(new Currency(68,"United States","USD"," US dollar"));
            currencyRepository.save(new Currency(69,"Estonia","EUR"," euro"));
            currencyRepository.save(new Currency(70,"Eswatini (Swaziland)","SZL"," lilangeni suazi"));
            currencyRepository.save(new Currency(71,"Ethiopia","ETB"," Ethiopian birr"));
            currencyRepository.save(new Currency(72,"Fiji","FJD"," Fijian dollar"));
            currencyRepository.save(new Currency(73,"Filipinas","PHP"," Philippine peso"));
            currencyRepository.save(new Currency(74,"Finland","EUR"," euro"));
            currencyRepository.save(new Currency(75,"France","EUR"," euro"));
            currencyRepository.save(new Currency(76,"Metropolitan France","EUR"," euro"));
            currencyRepository.save(new Currency(77,"FSU","RUB"," Russian ruble"));
            currencyRepository.save(new Currency(78,"Gabon","XAF"," CFA franc"));
            currencyRepository.save(new Currency(79,"Gambia","GMD"," Gambian Dalasi"));
            currencyRepository.save(new Currency(80,"Georgia","GEL"," Georgian lari"));
            currencyRepository.save(new Currency(81,"Ghana","GHS"," cedi ghanés"));
            currencyRepository.save(new Currency(82,"Gibraltar","GIP"," pound"));
            currencyRepository.save(new Currency(83,"Great Britain","GBP"," pound sterling"));
            currencyRepository.save(new Currency(84,"Greece","EUR"," euro"));
            currencyRepository.save(new Currency(85,"Grenade","XCD"," dollar"));
            currencyRepository.save(new Currency(86,"Greenland (Denmark)","DKK"," Danish krone"));
            currencyRepository.save(new Currency(87,"Guadalupe","EUR"," euro"));
            currencyRepository.save(new Currency(88,"Guam (USA)","USD"," US dollar"));
            currencyRepository.save(new Currency(89,"Guatemala","GTQ"," Guatemalan quetzal"));
            currencyRepository.save(new Currency(90,"Guiana","GYD"," Guyanese dollar"));
            currencyRepository.save(new Currency(91,"Guernsey","GGP"," pound"));
            currencyRepository.save(new Currency(92,"French Guiana","EUR"," euro"));
            currencyRepository.save(new Currency(93,"Guinea","GNF"," Guinean Franc"));
            currencyRepository.save(new Currency(94,"Guinea Bissau","XOF"," CFA franc"));
            currencyRepository.save(new Currency(95,"Equatorial Guinea","XAF"," CFA franc"));
            currencyRepository.save(new Currency(96,"Haiti","HTG"," Haitian Gourd"));
            currencyRepository.save(new Currency(97,"Netherlands","EUR"," euro"));
            currencyRepository.save(new Currency(98,"Honduras","HNL"," Honduran lempira"));
            currencyRepository.save(new Currency(99,"Hong Kong","HKD"," dollar"));
            currencyRepository.save(new Currency(100,"Hungary","HUF"," Hungarian Forint"));
            currencyRepository.save(new Currency(101,"India","INR"," indian rupee"));
            currencyRepository.save(new Currency(102,"Indonesia","IDR"," Indonesian Rupiah"));
            currencyRepository.save(new Currency(103,"Iraq","IQD"," Iraqi dinar"));
            currencyRepository.save(new Currency(104,"Iran","IRR"," Iranian Rial"));
            currencyRepository.save(new Currency(105,"Ireland","EUR"," euro"));
            currencyRepository.save(new Currency(106,"Isle of Man","IMP"," libra"));
            currencyRepository.save(new Currency(107,"Christmas Island","AUD"," Australian dollar"));
            currencyRepository.save(new Currency(108,"Mauritius","MUR"," Mauritian rupee"));
            currencyRepository.save(new Currency(109,"Iceland","ISK"," Icelandic Krona"));
            currencyRepository.save(new Currency(110,"Cayman Islands","KYD"," Caymanian dollar"));

        }
    }

}
