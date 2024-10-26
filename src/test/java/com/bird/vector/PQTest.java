package com.bird.vector;

import com.bird.vector.utils.ArrayTools;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @description：
 * @author： liuxiangqian
 * @date： 2024/10/17
 */
@Slf4j
public class PQTest {
    //测试： 查询最近的n个聚类中心的(id,dis)
    private static double[] vector = {588.3794, 829.8247, 696.3295, 208.68057, 847.9395, 34.91348, 292.50293, 918.407,
            694.7829,
            552.84216, 305.48657, 880.6632, 989.17004, 26.785732, 979.9074, 2.348423, 990.11957, 657.0556,
            627.16846, 435.4567, 265.644, 138.8315, 313.68393, 54.151356, 610.60956, 156.57103, 965.07385,
            693.679, 341.6648, 149.97626, 949.84766, 809.47235, 772.15466, 352.33783, 418.29645, 240.26155,
            163.04428, 981.5812, 802.04956, 640.2605, 187.09236, 981.3554, 217.06396, 996.76624, 886.9377,
            361.10962, 738.3766, 163.20628, 223.12206, 170.47238, 950.0401, 34.27768, 830.722, 617.7336,
            30.204475, 467.99176, 284.17212, 161.24034, 261.83545, 245.92012, 525.6424, 375.65714, 7.236123,
            762.6145, 675.20013, 534.9783, 233.1596, 81.053734, 8.801937, 626.7558, 897.2715, 894.1887, 776.3964,
            586.1495, 321.08533, 532.4676, 816.1712, 36.198975, 884.91925, 771.01227, 696.98785, 567.3483,
            433.1877, 963.39026, 749.64716, 363.04538, 10.374308, 185.31818, 704.81445, 760.63916, 436.85663,
            162.89818, 382.7903, 562.3682, 647.5493, 916.015, 635.07855, 717.68463, 163.87236, 226.31163,
            442.7235, 476.29123, 950.2637, 276.8513, 170.14343, 555.0478, 760.37286, 471.42197, 659.7735,
            18.384457, 835.8547, 467.82227, 351.98312, 891.24445, 53.629337, 621.90576, 411.7921, 409.18875,
            787.49274, 186.27083, 939.8635, 868.57135, 459.58633, 916.0364, 506.69147, 330.21002, 999.6455,
            959.01733, 258.0604, 715.4278, 838.91235, 631.8127, 744.58344, 829.5435, 165.5476, 567.9841,
            991.89685, 473.79596, 624.34515, 758.8822, 480.0108, 434.35812, 511.20065, 759.16516, 985.1094,
            841.73865, 488.40482, 193.14331, 265.11188, 203.7927, 517.3401, 148.42474, 467.52768, 562.22003,
            798.0873, 881.67017, 796.1618, 390.38528, 138.96776, 867.4879, 299.28094, 427.24997, 111.9411,
            803.6096, 808.7843, 968.97644, 231.46844, 29.623688, 756.2192, 760.2959, 14.9657135, 536.9601,
            271.2288, 539.09955, 322.98572, 536.9009, 100.96419, 190.10509, 658.0634, 431.64743, 210.46173,
            10.189951, 834.6527, 99.530045, 684.9836, 635.52246, 471.31253, 86.07275, 772.4201, 38.51491,
            343.43402, 592.6896, 609.30426, 683.5852, 654.11945, 907.3134, 665.6276, 400.54846, 506.7497,
            37.364185, 34.96206, 962.1216, 210.34753, 24.417103, 966.47516, 359.58337, 823.7164, 559.10895,
            79.00804, 683.2758, 492.80804, 719.73694, 374.821, 610.69446, 494.7558, 652.2838, 857.8699, 265.82654
            , 449.03784, 845.01227, 400.1627, 573.7365, 259.48322, 957.1863, 647.09314, 831.8616, 19.079388,
            396.90845, 631.4904, 644.88104, 242.20264, 543.6439, 314.96347, 417.3168, 426.0143, 540.98737,
            198.02815, 514.2673, 515.0019, 387.0089, 157.23747, 936.0829, 421.29462, 893.58563, 763.4232,
            810.66016, 300.35144, 321.13272, 11.186541, 293.82855, 899.45154, 797.8395, 912.54553, 143.58311,
            478.27768, 257.77847, 59.385063, 560.38367, 680.5527, 663.0983, 587.9092, 79.208374, 337.59363,
            873.06415, 47.14966, 778.4728, 673.8175, 176.23097, 311.83093, 708.3623, 316.33478, 278.9116,
            732.2643, 811.7823, 82.08913, 338.83362, 290.79236, 243.32124, 813.4629, 421.10788, 261.60114,
            616.79224, 784.39923, 836.10767, 140.07217, 514.64386, 22.061646, 75.47044, 826.47516, 460.49738,
            542.6548, 201.18285, 889.5687, 330.10733, 133.66592, 349.73932, 387.04486, 900.0883, 218.51003,
            602.9193, 135.8332, 404.8835, 194.02748, 541.2019, 475.80136, 790.8587, 757.77936, 855.7302,
            690.68555, 975.4132, 352.536, 48.689663, 91.160774, 195.04916, 302.2858, 426.72293, 843.38763,
            269.00546, 240.6764, 792.4687, 474.40433, 827.0353, 422.82605, 798.46674, 401.1984, 717.01025,
            739.31934, 256.67767, 126.686035, 589.21045, 131.97559, 534.95123, 2.2383332, 171.4825, 450.30524,
            836.3525, 767.5542, 828.11163, 31.74454, 793.808, 804.94226, 413.57578, 774.69586, 644.7049,
            62.410473, 171.77988, 678.6331, 829.6262, 549.9794, 926.47516, 618.2312, 316.21106, 853.555,
            197.04337, 7.427931, 241.19931, 163.3737, 246.49776, 393.9451, 627.19403, 317.945, 719.35657,
            445.1152, 329.80035, 523.6568, 203.0608, 172.55562, 947.9693, 944.5194, 198.0232, 167.57965, 956.0881
            , 751.23883, 11.536539, 543.1601, 639.2545, 474.91788, 606.07697, 804.2942, 710.00616, 394.7835,
            492.58487, 989.9306, 510.42795, 983.65125, 126.789215, 779.9969, 41.04525, 187.22481, 657.3731,
            364.9174, 368.353, 87.2556, 207.71783, 397.389, 235.49431, 623.16595, 520.1646, 342.73386, 502.86777,
            866.6886, 828.40625, 711.1772, 772.8168, 469.7502, 278.0761, 579.80884, 678.67316, 463.20425,
            319.28873, 221.32336, 645.044, 464.69772, 932.3767, 669.05853, 833.2342, 465.16745, 707.0513,
            422.1534, 681.0869, 878.051, 16.518295, 880.24115, 216.44402, 141.74818, 355.64374, 284.01495,
            782.1242, 318.27646, 343.16086, 106.92471, 150.1804, 299.1594, 622.33484, 815.46454, 244.73346,
            148.71776, 585.77435, 402.91022, 934.5192, 36.08155, 354.64496, 956.5034, 25.188805, 147.00096,
            69.96941, 984.1177, 682.25226, 957.14124, 316.6893, 187.16777, 881.3578, 587.8414, 365.53055,
            596.3557, 24.487614, 466.78967, 52.408157, 400.82336, 817.8862, 758.8042, 142.19475, 705.0605,
            697.4958, 610.6519, 268.35513, 787.7979, 155.86943, 28.922617, 280.5381, 50.002575, 994.59705,
            557.39575, 550.1627, 702.5277, 849.9645, 981.6784, 413.90634, 726.1259, 946.767, 221.39359, 114.49641
            , 746.1819, 383.9072, 796.70197, 918.141, 101.095436, 881.7724, 714.9301, 342.25607, 586.76825,
            689.654, 18.649101, 862.9277, 560.79517, 704.0288, 288.43225, 38.97774, 360.01218, 55.878403,
            87.06629, 591.91003, 285.93265, 836.00934, 168.17677, 724.83466, 846.83997, 918.3079, 517.6534,
            408.28473, 6.0685873, 266.91125, 233.1553, 769.33185, 7.0877075, 757.39624, 423.1887, 308.41376,
            951.8058, 565.424, 786.25555, 854.7325, 864.0943, 68.08251, 141.4798, 828.0576, 31.535208, 30.822039,
            769.6415, 77.451706, 181.1272, 511.8981, 98.05679, 844.1584, 596.0505, 380.24188, 650.19403, 978.0979
            , 848.12915, 913.43823, 672.92505, 609.666, 22.50725, 499.88293, 858.0993, 928.5356, 406.0614,
            721.22485, 763.54724, 389.7268, 748.61633, 824.00476, 100.14707, 598.2915, 676.1602, 917.24286,
            940.3247, 814.61993, 318.62592, 847.97833, 89.03134, 672.8192, 32.71067, 129.94295, 576.2013,
            468.14902, 464.5599, 130.27895, 230.91895, 602.584, 460.48135, 882.25775, 98.61302, 289.7674,
            239.34448, 893.19336, 595.77924, 924.6236, 171.75412, 489.19046, 559.8587, 84.534164, 742.8695,
            993.1449, 58.445812, 617.1876, 222.91893, 108.78885, 51.069496, 807.0694, 37.69487, 598.9249,
            843.1063, 23.251831, 266.89648, 845.82825, 95.30521, 313.99716, 438.02573, 389.74976, 829.89307,
            110.150696, 305.1876, 609.28345, 46.907307, 963.93475, 473.74493, 464.9467, 889.4747, 220.26485,
            62.138916, 632.6776, 697.0913, 784.9086, 480.70587, 443.2047, 200.02496, 11.647582, 394.05298,
            180.65411, 739.8605, 926.1442, 949.15094, 421.70828, 970.6714, 987.6679, 967.06006, 985.6255,
            487.67685, 764.5019, 474.0371, 564.1067, 246.50287, 871.1946, 290.2078, 385.1105, 242.92546,
            345.39713, 394.21307, 91.15106, 502.44223, 91.53926, 74.01395, 963.37885, 29.059113, 803.8666,
            981.8056, 358.96832, 546.7671, 821.32385, 799.7674, 740.28125, 964.4145, 33.510326, 348.8397,
            527.32086, 849.7867, 325.63138, 331.1498, 595.64886, 422.03946, 149.36096, 75.02723, 43.83445,
            789.1606, 867.2453, 377.29144, 669.4063, 260.47522, 225.3015, 928.82635, 800.06006, 460.57303,
            49.47722, 625.1619, 935.547, 833.2862, 377.47366, 953.28625, 351.36865, 640.94855, 272.02927,
            399.23764, 12.3814945, 189.23491, 512.1877, 618.85565, 35.05856, 211.12764, 925.5315, 777.67413,
            541.97314, 860.34814, 960.167, 707.2488, 169.69043, 845.89166, 56.84024, 196.7538, 148.43637,
            901.7237, 778.5301, 83.625435, 773.5465, 61.45632, 499.87973, 709.1658, 67.77853, 394.77734, 717.7316
            , 538.7564, 401.24326, 774.0293, 885.75287, 226.71461, 31.226337, 454.7341, 722.75745, 438.50977,
            764.90955, 367.7525, 521.0442, 274.34564, 879.4827, 893.5144, 366.1855, 4.9065948, 779.9767,
            896.32764, 854.6817, 9.909153, 687.12103, 80.772995, 795.2977, 671.16034, 555.5069, 449.8498,
            141.42061, 522.8802, 884.3283, 218.69553, 616.2467, 102.52637, 635.1218, 906.85004, 953.95685,
            715.28564, 977.4696, 200.26183, 635.35065, 155.45392, 486.97482, 261.27475, 395.8744, 389.38123,
            990.45197, 456.03568, 530.91315, 259.44537, 839.8428, 465.10614, 224.07425, 519.15967, 675.6239,
            711.1419, 338.53143, 449.19254, 967.29675, 259.5554, 602.02936, 66.560684, 875.95557, 371.9446,
            98.678825, 548.9742, 433.04474, 781.23456, 874.1552, 118.29168, 159.50172, 341.04025, 137.41774,
            816.9616, 127.91932, 824.44293, 576.7797, 565.4581, 992.65674, 419.53214, 229.41852, 693.9946,
            652.6199, 516.6769, 882.6436, 25.740803, 270.47067, 97.15349, 327.0305, 169.55388, 230.19844,
            821.70197, 813.55566, 216.64703, 980.3011, 453.659, 629.9726, 677.0685, 368.4129, 722.9988, 849.77344
            , 528.4006, 139.3342, 99.004684, 517.2798, 361.36426, 434.4545, 160.12598, 14.875591, 116.32651,
            917.0173, 565.18915, 266.46268, 22.969543, 153.18655, 791.5136, 121.33736, 435.12302, 30.200422,
            329.22983, 544.4082, 37.16147, 794.91876, 439.434, 624.71454, 771.2045, 81.79557, 694.59973,
            370.36914, 70.047615, 479.86914, 636.3664, 453.28873, 994.33734, 503.01636, 87.55118, 623.46075,
            469.6447, 593.8525, 36.705135, 255.22107, 446.0786, 154.77222, 935.106, 195.4025, 796.82794, 783.3651
            , 583.7326, 736.70593, 610.0695, 445.547, 183.09193, 573.815, 79.188705, 378.11893, 229.00665,
            152.31354, 968.0209, 31.099438, 685.456, 982.19934, 20.254612, 375.20993, 689.78986, 552.6531,
            235.26942, 775.58246, 150.19005, 199.8008, 577.1863, 311.49112, 199.8722, 94.68663, 991.07324,
            674.18396, 62.551617, 837.8741, 31.983316, 449.34995, 460.11716, 576.46576, 571.3505, 864.1523,
            22.866726, 158.44214, 924.39264, 705.97504, 27.286768, 370.76062, 975.3591, 684.0737, 234.05367,
            487.45816, 989.1288, 667.3296, 193.17871, 100.99572, 452.8497, 980.5307, 453.10568, 896.3513,
            545.67834, 845.43054, 0.83363056, 728.1026, 384.51755, 506.77527, 581.125, 104.25776, 625.8751,
            61.166466, 420.5488, 198.34293, 46.11331, 309.81088, 208.09996, 487.80762, 492.5977, 464.7705,
            865.6605, 439.85355, 855.3671, 460.28226, 851.4697, 676.16064, 102.35333, 242.19507, 166.53323,
            289.60855, 740.9144, 343.83316, 331.62244, 456.051, 495.1778, 498.02054, 840.92114, 882.68933,
            343.70428, 3.0969381, 712.82367, 614.9248, 57.193935, 154.1618, 999.8443, 142.19868, 863.90924,
            696.2452, 504.67538, 909.82245, 94.335556, 958.5189, 510.3472, 270.85037, 500.1436, 921.0252,
            367.05316, 565.4786, 180.1594, 858.8515, 99.985, 564.2112, 592.83795, 642.4771, 390.5771, 577.1827,
            296.3277, 64.539734, 932.6089, 440.768, 779.90576, 358.0271, 135.01727, 622.2647, 871.26385,
            92.526436, 810.999, 315.43576, 700.3763, 935.4128, 999.64, 568.63873, 440.64145, 973.61884, 569.11884
            , 830.8212, 40.459454, 866.9036, 172.3516, 409.6589, 802.78613, 581.4603, 405.24304, 4.4989586,
            6.5442324, 697.5374, 358.59756, 951.61237, 222.73094, 738.8656, 876.9362, 50.753475, 630.92377,
            905.60126, 726.32745, 733.4942, 450.5809, 354.84708, 29.836655, 991.6862, 668.57837, 440.34427,
            19.936144, 468.27878, 63.006165, 350.5396};

    private static float[] floatVector = ArrayTools.toFloatArr(vector);

    public static void main(String[] args) {
        int pqSegmentCount = 16;
        int clusterCount = 16;
        int maxIterCount = 100;
        int vectorDimension = 1024;

        //测试： 训练
        String csvFile = "data/test.txt";
        EmPQ pq = new EmPQ(pqSegmentCount, clusterCount, maxIterCount, vectorDimension);
        pq.train(csvFile);

        List<List<Pair<Integer, Float>>> centersList = pq.search(floatVector, 10);
        log.info("聚类中心:{}", centersList);

        //测试： 量化得到最匹配的聚类中心id
        List<Integer> clusterIds = pq.pq(floatVector);
        log.info("量化结果:{}", clusterIds);

        //测试： 模型存储与加载
        String modelDir = "pqmodel/";
        pq.store(modelDir);
        pq = new EmPQ(pqSegmentCount, clusterCount, maxIterCount, vectorDimension);
        pq.load(modelDir);
        centersList = pq.search(floatVector, 10);
        clusterIds = pq.pq(floatVector);

        log.info("聚类中心:{}", centersList);
        log.info("量化结果:{}", clusterIds);
    }
}
