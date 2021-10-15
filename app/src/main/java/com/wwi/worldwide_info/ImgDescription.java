package com.wwi.worldwide_info;

public class ImgDescription {
    String[][] description, title;
    int[][] images;


    public ImgDescription() {
        init();
        setTitle();
        setDescriptionText();
        setImages();
    }

    String getDescriptionText(int country, int img) {
        return description[country][img];
    }

    String getTitle(int country, int img) {
        return title[country][img];
    }

    int getImages(int country, int img) {
        return images[country][img];
    }

    private void init() {
        title = new String[10][3];
        description = new String[10][3];
        images = new int[10][3];
    }

    public void setTitle() {
//        일본
        title[0][0] = "이쓰쿠시마 신사 도리이";
        title[0][1] = "도쿄";
        title[0][2] = "후지산";

//        한국
        title[1][0] = "경복궁";
        title[1][1] = "롯데타워";
        title[1][2] = "서울";

//        중국
        title[2][0] = "자금성";
        title[2][1] = "만리장성";
        title[2][2] = "중국의 요리";

//        인도
        title[3][0] = "타지마할";
        title[3][1] = "코끼리";
        title[3][2] = "인도의 요리";

//        러시아
        title[4][0] = "성 바실리 대성당";
        title[4][1] = "영토";
        title[4][2] = "보드카";

//        이집트
        title[5][0] = "스핑크스";
        title[5][1] = "피라미드";
        title[5][2] = "나일강";

//        이탈리아
        title[6][0] = "피사의 사탑";
        title[6][1] = "콜로세움";
        title[6][2] = "이탈리아의 요리";

//        프랑스
        title[7][0] = "에펠탑";
        title[7][1] = "파리";
        title[7][2] = "개선문";

//        칠레
        title[8][0] = "이스터 섬의 모아이";
        title[8][1] = "산티아고";
        title[8][2] = "영토";

//        미국
        title[9][0] = "자유의 여신상";
        title[9][1] = "다문화";
        title[9][2] = "뉴욕";
    }

    void setDescriptionText() {
//        일본
        description[0][0] = "일본 히로시마현 이츠쿠시마에\n위치한 신사에 있는 \'도리이\' 며\n도리이는 일반적으로 일본의 신사의 입구이다\n" +
                "이쓰쿠시마 신사의 도리이는 바다에 있다는 점과\n아름다운 디자인으로 일본의 대표 랜드마크가 되었으며\n이쓰쿠시마 신사는 현재 유네스코 \n세계유산으로 등재되어있다.";
        description[0][1] = "일본의 수도이자 세계 최대의 도시권인\n도쿄 광역권의 핵심 도시.\n일본의 정치, 경제, 문화, 교육,\n" +
                "금융, 산업, 교통, 패션의 중심지이며\n세계적으로도 뉴욕, 런던과 함께\n세계 3대도시중 한 곳으로 뽑힌다.";
        description[0][2] = "후지산은 일본에서 가장 높은 산으로,\n해발고도 3,776m인 성층화산이자 활화산이다.\n" +
                "일본의 상징이자 일본인의 영산으로 꼽히며\n 유네스코 세계유산으로 등재되어있다.";

//        한국
        description[1][0] = "조선시대에 가장 먼저 지어진 궁궐로써\n사적 제 117호로 지정되어 있다.\n경복궁이라는 이름에는\n" +
                "\'새 왕조가 큰 복을 누려 번영할 것\'\n이라는 의미가 담겨 있다.\n1395년 태조 이성계가 창건하였고,\n" +
                "1592년 임진왜란으로 불타 없어졌다가,\n고종 때인 1867년 중건 되었다.";
        description[1][1] = "지상 123층, 높이 554.5m로\n대한민국 최고층 건물이자 세계에서\n5번째로 높은 건물이다.\n" +
                "2011년 ~ 2017년 동안 최고층 마천루였던\n포스코타워-송도를 제치고 2017년부터\n최고층 마천루의 자리를 지키고있다." +
                "타워동에는 5성급호텔과 오피스,\n오피스텔, 전망대, 쇼핑몰 등이 있다.";
        description[1][2] = "서울특별시는 대한민국의\n 최대 도시이자 수도이며\n법률상 대한민국 제 1의 도시로 규정되어 있다.\n" +
                "현재 대한민국 유일 특별시이며\n북한까지 포함해도 북한 최대 도시\n평양의 인구가 300만 명밖에 되지않아\n" +
                "현재 명실상부한 한반도의 종주 도시이다.";

//        중국
        description[2][0] = "중국 베이징 중심부에 위치한 궁궐로,\n현존하는 궁궐로는 세계 최대 규모를 자랑하며\n5백년 동안 명나라 º 청나라 두 왕조\n" +
                "24명의 황제가 이 곳에서 중국을 통치하였다.\n720,000㎡의 면적을 가지고 있는데 이는\n올림픽공원의 절반정도의 크기이며\n유네스코 세계유산으로 등재되어있다.";
        description[2][1] = "유목민족의 침략을 막기 위해 중국이\n여러 시대에 걸쳐 북방에 건축한 성곽이며\n인류가 만든 가장 거대한 건축물이다.\n" +
                "이름은 만리장성이지만 실제 길이는\n6350km로 약 16000리 이다.\n유네스코 세계유산으로 등재되어있다.";
        description[2][2] = "중국요리는 재료와 조리법이 무궁무진하며,\n지리와 기후가 다양하며 인구도 많아\n 지방별로 특색이 확살한 요리가 풍부하여\n우리는 흔히 북경 º 사천 º 상해 º 광둥\n" +
                "요리를 중국 4대요리 라고 말하지만\n실제로는 안후이 º 푸젠 º 저장 º 후난\n 광둥 º 산둥 º 쓰촨 º 장쑤의 8대 요리 가 기본이다.";

//        인도
        description[3][0] = "타지마할은 당시 황제였던 \'샤 자한\' 의\n지시로 지어진 황후의 무덤이며\n인도 건축의 정수로서 대표적인 랜드마크이다.\n" +
                "모든 것이 단지 한 황제의 순애보적 집념만으로\n 그 당대에 착공하여 환성하였다는 점 또한 큰 특징이다.\n유네스코 세계유산에 등재되어있다.";
        description[3][1] = "인도는 인구의 대부분이 힌두교인데\n힌두교에는 코끼리 머리의 형상을 한\n\'가네샤\' 라는 신이 존재한다.\n" +
                "이 영향으로 인도에서 코끼리는\n신성한 동물이라는 인식이 강하며\n그로인해 길거리에서 코끼리를\n어렵지 않게 찾아볼 수 있다.";
        description[3][2] = "인도요리는 빵, 밥과 같이 먹는 커리가 유명하며\n대표적으로 4종류(옐로우, 레드, 그린, 마사만)\n로 나눌 수 있다. 그리고\n" +
                "인도요리는 힌두교, 무슬림의 영향으로\n 소고기와 돼지고기보단 닭, 염소\n등의 고기를 사용하는 요리가 보편적이다.";

//        러시아
        description[4][0] = "성 바실리 대성당은 모스크바의\n붉은 광장에 있는 정교회 성당이다.\n1988년 출시되었던 테트리스 게임의\n" +
                "메인화면에 등장하였기 때문에\n흔히 테트리스 성당이라고 불리웠으며,\n대성당은 옆의 붉은 광장, 크렘린 궁과 함께\n유네스코 세계유산에 등재되어있다.";
        description[4][1] = "러시아 영토의 면적은\n17,125,407㎢로 세계 최대이며\n이는 유럽, 오세아니아, 남극대륙 전체보다 넓으며\n" +
                "남아프리카 대륙보다는 조금 작은 크기로\n 총 11개의 시간대를 사용한다.";
        description[4][2] = "러시아 하면 떠오르는 이미지중\n보드카를 빼놓을 순 없는데,\n보드카의 어원은 \'물\' 이란 뜻으로\n 이때문인지 예전부터 남자들의\n" +
                "과도한 음주문화가 보편적으로 통하고있다.\n 근래에는 큰 사회문제가 되고 있어\n정부에서 이를 해결하고자 하고있다.";

//        이집트
        description[5][0] = "";
        description[5][1] = "";
        description[5][2] = "나일강은 아프리카 대륙의 동북부를 흐르는 강이다.\n총 길이는 6,650km 이며 세계에서 가장 긴 강이다.\n" +
                "일반적인 강과 다른점으로 정기적으로 범람하는것이 있는데\n이때 영양소가 풍부한 부엽토, 부식토를\n하류 이집트에 가득 옮겨주게 되는데\n" +
                "이는 고대 이집트 문명의 번영의 중요한 역할을 했다.";

//        이탈리아
        description[6][0] = "토스카나 주 피사 시의\n피사 대성당에 딸린 높이 55m의 종탑이다.\n기울어져 비스듬하게 서있는 것으로 유명하며\n" +
                "부드러운 지반과 지면을 3m만 판 상태로\n공사를 진행한것이 기울어진 원인이다.\n유네스코 세계유산으로 등재되어있다.";
        description[6][1] = "고대 로마시대에 건설된 투기장\n원 이름은 \'플라비우스 원형극장\' 으로\n본래 원형극장은 검투사경기나\n" +
                "서커스 관람 등을 하는 스타디움의 개념의\n\'엠피시어터\'와 희곡, 연주 등을 행하는\n예술적 상영장인 \'엠피시어터\' 가 있다,\n" +
                "우리가 콜로세움이라 부르는것은\n로마 중심지에 있고 제일 큰 크기와 보존이 잘된 하나이다.";
        description[6][2] = "이탈리아에서 기원한 혹은\n이탈리아에서 먹는 음식 스타일을\n통틀어 이탈리아 요리라고 부르며\n" +
                "대표적으로 피자, 파스타 등이 있으며\n유지류로 버터보다 올리브유를 주로 사용하는 점,\n채소, 특히 토마토를 많이 사용하는 점,\n" +
                "그리고 탄수화물과 단백질 비율을\n적정선으로 유지하는 등의 특징이 있다.";

//        프랑스
        description[7][0] = "프랑스의 철골 구조물이며\n근대건축의 혁신점 중 하나이다.\n1889년에 300m라는 경이적인 높이를 달성,\n" +
                "1930년까지 크라이슬러 빌딩이 완공되기\n전까진 세계에서 가장 높은 구조물이었다.\n유네스코 세계유산으로 등재되어있다.";
        description[7][1] = "프랑스의 수도이자 최대 도시이며\n유럽의 대표적인 관광 명소이기도 하다.\n세계적으로도 큰 영향력을 끼치는 대도시이며,\n" +
                "영국의 런던, 독일의 프랑크푸르트와 함께\n유럽의 금융과 경제를 담당하는\n중요한 거점 도시이다.";
        description[7][2] = "에투알 개선문은 프랑스 파리에 위치한 개선문이며\n프랑스 혁명과 나폴레옹 전쟁 시기에 죽은\n프랑스 병사들을 기리기 위하여 지어졌다.\n" +
                "제1차 세계대전, 제2차 세계대전, 68혁명 등\n프랑스 근현대사의 굵직한 사건들을 함께한\n프랑스의 상징과도 같은 건축물이다.";

//        칠레
        description[8][0] = "\'라파누이 국립공원\' 이란 이름으로\n유네스코 세계유산에 등재되어 있는 이곳은\n모아이 석상으로 유명하다.\n" +
                "모아이의 생김새는 특이하게 생겼지만\n신을 묘사한 것이라고 하며\n폴리네시아 지역의 전통적인 석상들과\n디자인 면에서 연결성이 있다.";
        description[8][1] = "길쭉한 칠레 영토의 중앙에 위치하고 있고\n인구는 주변 지역을 합하여 약 610만 명이다.\n칠레에서 가장 큰 도시이며\n" +
                "칠레 인구의 1/3이 이곳에 거주한다.\n대다수의 정부 기관과 대통령궁 \n\'라 모네다(La Moneda)\'가 위치해 있다.\n" +
                "남미에서 가장 높은 빌딩인 \n\'그란 토레 산티아고\' 가 있는 곳이다.";
        description[8][2] = "칠레의 국토는 동서로는 폭이 좁은 반면\n(가장넓은 지역도 350km 남짓, 평균 177km),\n남북으로 길다랗게 뻗어있는(약 4,270km)\n" +
                "묘한 형태를 지니고 있다.\n남북으로 워낙 긴 데다가 고산지대까지 있는 바람에,\n한 국가 내에서 최소 7개의\n기후대를 경험해 볼 수 있다.";

//        미국
        description[9][0] = "뉴욕 리버티 섬에 세워진 93.5m의 여신상으로\n미국, 아메리칸 드림의 상징이다.\n" +
                "정식명칭은 \'Liberty Enlightening the World\'\n이며 \'세계를 밝히는 자유\'하는 뜻이다.\n" +
                "원래는 구리의 붉은빛을 띠었었지만\n공기중에서 서서히 산화하는\n구리의 특성상 푸른빛으로 변하게 되었다.";
        description[9][1] = "미국은 인종의 용광로라고 불릴만큼\n정말 다양한 인종이 섞여서 지내고 있다.\n2020년 미국의 인종 비율은\n" +
                "(유럽계) 미국 백인 57.8%\n(종남미계) 히스패닉 18.7%\n(아프리카계) 미국 흑인 12.1%\n아시아계 미국인 5.9%\n아메리카 원주민 0.7%\n" +
                "로 구성되어 있다.";
        description[9][2] = "뉴욕시는 미국 뉴욕주 남부 지역에\n위치한 미국의 최대도시이다\n세계에서 가장 번화하고 유명한 계획도시이며\n" +
                "세계 경제, 문화, 패션의 중심지로써\n\'세계의 수도\' 라는 호칭이 있으며,\n도쿄, 런던과 함께 세계 3대 도시중 한 곳으로 불린다.";
    }

    void setImages() {
//        일본
        images[0][0] = R.drawable.ic_launcher_background;
        images[0][1] = R.drawable.ic_launcher_background;
        images[0][2] = R.drawable.ic_launcher_background;

//        한국
        images[1][0] = R.drawable.ic_launcher_background;
        images[1][1] = R.drawable.ic_launcher_background;
        images[1][2] = R.drawable.ic_launcher_background;

//        중국
        images[2][0] = R.drawable.ic_launcher_background;
        images[2][1] = R.drawable.ic_launcher_background;
        images[2][2] = R.drawable.ic_launcher_background;

//        인도
        images[3][0] = R.drawable.ic_launcher_background;
        images[3][1] = R.drawable.ic_launcher_background;
        images[3][2] = R.drawable.ic_launcher_background;

//        러시아
        images[4][0] = R.drawable.ic_launcher_background;
        images[4][1] = R.drawable.ic_launcher_background;
        images[4][2] = R.drawable.ic_launcher_background;

//        이집트
        images[5][0] = R.drawable.ic_launcher_background;
        images[5][1] = R.drawable.ic_launcher_background;
        images[5][2] = R.drawable.ic_launcher_background;

//        이탈리아
        images[6][0] = R.drawable.ic_launcher_background;
        images[6][1] = R.drawable.ic_launcher_background;
        images[6][2] = R.drawable.ic_launcher_background;

//        프랑스
        images[7][0] = R.drawable.ic_launcher_background;
        images[7][1] = R.drawable.ic_launcher_background;
        images[7][2] = R.drawable.ic_launcher_background;

//        칠레
        images[8][0] = R.drawable.ic_launcher_background;
        images[8][1] = R.drawable.ic_launcher_background;
        images[8][2] = R.drawable.ic_launcher_background;

//        미국
        images[9][0] = R.drawable.ic_launcher_background;
        images[9][1] = R.drawable.ic_launcher_background;
        images[9][2] = R.drawable.ic_launcher_background;
    }
}
