// Copyright 2012 Citrix Systems, Inc. Licensed under the
// Apache License, Version 2.0 (the "License"); you may not use this
// file except in compliance with the License.  Citrix Systems, Inc.
// reserves all rights not expressly granted by the License.
// You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// 
// Automatically generated by addcopyright.py at 04/03/2012
package com.cloud.network.vpc.Dao;

import javax.ejb.Local;

import com.cloud.network.vpc.VpcGateway;
import com.cloud.network.vpc.VpcGatewayVO;
import com.cloud.utils.db.DB;
import com.cloud.utils.db.GenericDaoBase;
import com.cloud.utils.db.SearchBuilder;
import com.cloud.utils.db.SearchCriteria;

/**
 * @author Alena Prokharchyk
 */

@Local(value = VpcGatewayDao.class)
@DB(txn = false)
public class VpcGatewayDaoImpl extends GenericDaoBase<VpcGatewayVO, Long> implements VpcGatewayDao{
    protected final SearchBuilder<VpcGatewayVO> AllFieldsSearch;
    
    protected VpcGatewayDaoImpl() {
        AllFieldsSearch = createSearchBuilder();
        AllFieldsSearch.and("vpcId", AllFieldsSearch.entity().getVpcId(), SearchCriteria.Op.EQ);
        AllFieldsSearch.and("type", AllFieldsSearch.entity().getType(), SearchCriteria.Op.EQ);
        AllFieldsSearch.done();
    }


    @Override
    public VpcGatewayVO getPrivateGatewayForVpc(long vpcId) {
        SearchCriteria<VpcGatewayVO> sc = AllFieldsSearch.create();
        sc.setParameters("vpcId", vpcId);
        sc.setParameters("type", VpcGateway.Type.Private);

        return findOneBy(sc);
    }

    @Override
    public VpcGatewayVO getVpnGatewayForVpc(long vpcId) {
        SearchCriteria<VpcGatewayVO> sc = AllFieldsSearch.create();
        sc.setParameters("vpcId", vpcId);
        sc.setParameters("type", VpcGateway.Type.Vpn);

        return findOneBy(sc);
    }

}
