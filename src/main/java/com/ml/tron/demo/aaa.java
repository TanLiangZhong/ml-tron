package com.ml.tron.demo;

/**
 * @author liangzhong
 * @date 2019/3/6 15:49
 */
public class aaa {

//    public void HistoricalRecord()
//    {
//        StringBuilder bs = new StringBuilder();
//
//        try
//        {
//            string contractaddress = "0xba7435A4b4C747E0101780073eedA872a69Bdcd4";// 代币的智能合约地址
//            string address = "0x91A47852Eeb94125374f4373B8d785fE96d417eD";//查询地址
//            string startblock = "5718334";//开始ID
//            int page = 0;//分页，可选
//            int offset = 0; //查询到记录数，可选
//            string histprecal_aip = $"https://api.etherscan.io/api?module=account&action=tokentx&contractaddress={contractaddress}&address={address}&page=1&offset=100&startblock={startblock}&sort=desc&apikey=YourApiKeyToken";
//            string retString = SendGet(histprecal_aip);
//            HistoricalModel historicalModel = JsonConvert.DeserializeObject<HistoricalModel>(retString);
//            if (historicalModel != null)
//            {
//                if (historicalModel.status == 1 && historicalModel.message == "OK")
//                {
//
//                }
//                else
//                {
//                    bs.Append($"错误信息:{historicalModel.message}\r\n");
//                }
//            }
//            else
//            {
//                bs.Append($"请求错误\r\n");
//            }
//
//        }
//        catch (Exception ex)
//        {
//            bs.Append(ex.Message + "\r\n");
//        }
//        finally
//        {
//            StreamWriter sW2 =
//                    new StreamWriter(
//                            AppDomain.CurrentDomain.BaseDirectory + "log\\" + "核心等级升级" + DateTime.Now.ToString("yyyyMMddhhmmsss") + ".log", false, Encoding.UTF8);
//            sW2.Write(bs.ToString());
//            sW2.Close();
//        }
//    }
//
//    private class HistoricalModel
//    {
//        /// <summary>
//        /// 返回状态码：1 代表成功，其它代表失败
//        /// </summary>
//        public int status { get; set; }
//
//        /// <summary>
//        /// 返回信息
//        /// </summary>
//        public string message { get; set; }
//
//        public List<HistoricalRecordModel> result { get; set; }
//    }
//
//    private class HistoricalRecordModel
//    {
//        /// <summary>
//        /// 区块编号
//        /// </summary>
//        public string blockNumber { get; set; }
//
//        /// <summary>
//        /// 时间戳
//        /// </summary>
//        public string timeStamp { get; set; }
//
//        /// <summary>
//        /// 交易hash
//        /// </summary>
//        public string hash { get; set; }
//
//        /// <summary>
//        /// 交易序号
//        /// </summary>
//        public string nonce { get; set; }
//
//        /// <summary>
//        /// 区块hash
//        /// </summary>
//        public string blockHash { get; set; }
//
//        /// <summary>
//        /// 代币地址
//        /// </summary>
//        public string contractAddress { get; set; }
//
//        /// <summary>
//        /// 交易发起方地址
//        /// </summary>
//        public string from { get; set; }
//
//        /// <summary>
//        /// 交易收款方地址
//        /// </summary>
//        public string to { get; set; }
//
//        /// <summary>
//        /// 交易额度
//        /// </summary>
//        public string value { get; set; }
//
//        /// <summary>
//        /// 代币位数
//        /// </summary>
//        public string tokenDecimal { get; set; }
//    }

}
